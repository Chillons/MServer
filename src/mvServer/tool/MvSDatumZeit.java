/*
 * MediathekView
 * Copyright (C) 2008 W. Xaver
 * W.Xaver[at]googlemail.com
 * http://zdfmediathk.sourceforge.net/
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package mvServer.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MvSDatumZeit {

    private static final SimpleDateFormat sdf_stunde_minute = new SimpleDateFormat("HH:mm");
    private static final SimpleDateFormat sdf_datum_zeit = new SimpleDateFormat("dd.MM.yyyy  HH:mm:ss");
    private static final SimpleDateFormat sdf_datum = new SimpleDateFormat("dd.MM.yyyy");
    private static final SimpleDateFormat sdf_datum_yyyy_MM_dd = new SimpleDateFormat("yyyy.MM.dd");

    public static String getJetzt() {
        return sdf_datum_zeit.format(new Date());
    }

    public static String getJetztLogDatei() {
        return new SimpleDateFormat("__yyyy.MM.dd__HH:mm:ss").format(new Date());
    }

    public static String getJetzt_hh_mm() {
        return sdf_stunde_minute.format(new Date());
    }

    public static String getHeute() {
        return sdf_datum.format(new Date());
    }

    public static String getHeute_yyyy_MM_dd() {
        return sdf_datum_yyyy_MM_dd.format(new Date());
    }

    public static Date convertDatum(String datum) {
        try {
            return sdf_datum.parse(datum);
        } catch (Exception ex) {
            MvSLog.fehlerMeldung(852414170, MvSDatumZeit.class.getName(), datum, ex);
            return new Date();
        }
    }

    public static Date convertDateTime(String datumZeit) {
        try {
            return sdf_datum_zeit.parse(datumZeit);
        } catch (Exception ex) {
            MvSLog.fehlerMeldung(919596320, MvSDatumZeit.class.getName(), datumZeit, ex);
            return new Date();
        }
    }
}
