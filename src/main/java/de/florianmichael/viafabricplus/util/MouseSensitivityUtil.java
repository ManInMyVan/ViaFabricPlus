/*
 * This file is part of ViaFabricPlus - https://github.com/FlorianMichael/ViaFabricPlus
 * Copyright (C) 2021-2023 FlorianMichael/EnZaXD
 * Copyright (C) 2023      RK_01/RaphiMC and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.florianmichael.viafabricplus.util;

import it.unimi.dsi.fastutil.floats.FloatIntPair;

public class MouseSensitivityUtil {

    public static FloatIntPair get1_13SliderValue(final float value1_14) {
        final int oldSliderWidth = 150 - 8;
        final int mousePos = (int) (oldSliderWidth * value1_14);
        final float oldValue = mousePos / (float) oldSliderWidth;
        final int oldDisplay = (int) (oldValue * 200);
        return FloatIntPair.of(oldValue, oldDisplay);
    }

}
