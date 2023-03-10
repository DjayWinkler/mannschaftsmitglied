/*
 * Copyright (C) 2022 - present Juergen Zimmermann, Hochschule Karlsruhe
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
package com.acme.mannschaftsmitglied.entity;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Enum für Geschlecht. Dazu können auf der Clientseite z.B. Radiobuttons realisiert werden.
 */
@SuppressWarnings("VisibilityModifier")
public enum GeschlechtType {
    /**
     * _Männlich_ mit dem internen Wert `M` für z.B. das Mapping in einem JSON-Datensatz oder
     * das Abspeichern in einer DB.
     */
    MAENNLICH("M"),

    /**
     * _Weiblich_ mit dem internen Wert `W` für z.B. das Mapping in einem JSON-Datensatz oder
     * das Abspeichern in einer DB.
     */
    WEIBLICH("W"),

    /**
     * _Divers_ mit dem internen Wert `D` für z.B. das Mapping in einem JSON-Datensatz oder Abspeichern in einer DB.
     */
    DIVERS("D");
    /**
     * String Value.
     */
    public final String value;

    /**
     * Geschlechtstyp.
     *
     * @param value Wert
     */
    GeschlechtType(final String value) {
        this.value = value;
    }

    /**
     * Einen enum-Wert als String mit dem internen Wert ausgeben.
     * Dieser Wert wird durch Jackson in einem JSON-Datensatz verwendet.
     * [<a href="https://github.com/FasterXML/jackson-databind/wiki">Wiki-Seiten</a>]
     *
     * @return Interner Wert
     */
    @JsonValue
    @Override
    public String toString() {
        return value;
    }

    /**
     * Geschlechtstyp.
     *
     * @param value Wert
     * @return Geschlecht
     */
    public static Optional<GeschlechtType> of(final String value) {
        return Stream.of(values())
            .filter(geschlecht -> geschlecht.value.equals(value))
            .findFirst();
    }
}
