# ViaFabricPlus
Clientside ViaVersion, ViaLegacy and ViaAprilFools implementation with clientside fixes for Fabric
### This project has nothing to do with the original ViaFabric and is therefore also not compact

## Contact
If you encounter any issues, please report them on the
[issue tracker](https://github.com/FlorianMichael/ViaFabricPlus/issues).  
If you just want to talk or need help with ViaFabricPlus feel free to join my
[Discord](https://discord.gg/BwWhCHUKDf).

## To-do list
- [ ] ClassiCube implementation for MP Pass 
- [ ] BetaCraft server list screen
- [ ] ViaBedrock implementation
- [ ] Window click interactions in <= 1.16.5
- [ ] More extensions for Classic Protocol Extensions protocol

## Why?
ViaFabricPlus implements ViaLegacy/ViaAprilFools clientside and adds a ton of fixes that improve the game experience, <br>
as does [multiconnect](https://github.com/Earthcomputer/multiconnect) from Earthcomputer.
### Important: The focus on ViaFabricPlus is on client side fixes, so reporting bugs and contributing is welcome.

## Dependencies
| Dependency     | Download                                                   |
|----------------|------------------------------------------------------------|
| ViaVersion     | https://github.com/ViaVersion/ViaVersion                   |
| ViaBackwards   | https://github.com/ViaVersion/ViaBackwards                 |
| Snake YAML     | https://mvnrepository.com/artifact/org.yaml/snakeyaml/1.33 |
| ViaLegacy      | https://github.com/RaphiMC/ViaLegacy                       |
| ViaAprilFools  | https://github.com/RaphiMC/ViaAprilFools                   |
| MC-Structs     | https://github.com/Lenni0451/MCStructs                     |
| ViaLoadingBase | https://github.com/FlorianMichael/ViaLoadingBase           |

## Setting up a Workspace
ViaFabricPlus uses Gradle, to make sure that it is installed properly you can check [Gradle's website](https://gradle.org/install/).
1. Clone the repository using `git clone https://github.com/FlorianMichael/ViaFabricPlus`.
2. CD into the local repository.
3. Run `./gradlew genSources`.
4. Open the folder as a Gradle project in your preferred IDE.
5. Run the mod.

## Settings
Settings are optional settings that can turn fixes on and off, originally they were used for debugging<br>
![](/image/settings.png)

## Addons
To make a ViaFabricPlus addon you just have to implement the ViaFabricPlusAddon interface in your main class:
```java
package net.example;

public class ViaFabricPlusExampleAddon implements ViaFabricPlusAddon {
    
    @Override
    public void onLoad() {
        // called after ViaVersion and Minecraft is initialized
    }
    
    @Override
    public void onChangeVersion(ComparableProtocolVersion protocolVersion) {
        // called when the user changes the target version in the gui
    }
}
```
To load the addon you have to specify the addon main class as entrypoint in your *fabric.mod.json*:
```json
{
  "entrypoints": {
    "viafabricplus": [
      "net.example.ViaFabricPlusExampleAddon"
    ]
  }
}
```

### General API
In case you need an event as soon as the idle packet is skipped in the <= 1.8, you can do that: <br>
```java
IdlePacketExecutor.registerIdlePacketSkipExecute(() -> {
    // Called when the idle packet is skipped
});
```

In case you need the release version of a material, you can do that:
```java
final ProtocolRange range = ItemReleaseVersionDefinition.getItemMap().get(Items.WRITABLE_BOOK); // If an item does not appear in the item map, it has always existed

// The Range class then contains all versions in which the item occurs. 
// You can find out how the Range class works in the ViaLoadingBase README.
// https://github.com/FlorianMichael/ViaLoadingBase
```

To create a setting group, you can simply use the SettingGroup class:
```java
public class ExampleSettingGroup extends SettingGroup {
    public final static ExampleSettingGroup INSTANCE = new ExampleSettingGroup();
    
    public final BooleanSetting test = new BooleanSetting("Test", false);
    
    public ExampleSettingGroup() {
        super("Example");
        ViaFabricPlus.getClassWrapper().loadGroup(this); // should be in your onLoad method
    }
}
```

## Alternatives
- [ClientViaVersion](https://github.com/Gerrygames/ClientViaVersion): Discontinued 5zig plugin.
- [multiconnect](https://www.curseforge.com/minecraft/mc-mods/multiconnect): Fabric mod for connecting to older
  versions: down to 1.11 (stable) and 1.8 (experimental).
- [ViaFabric](https://www.curseforge.com/minecraft/mc-mods/viafabric): Client-side and server-side ViaVersion implementation for Fabric

## WARNING
**I cannot guarantee that this mod is allowed on every (or even any) server. This mod may cause problems with anti cheat
plugins. USE AT OWN RISK**
