# 📱 StandKassePro

> **Die minimalistische, werbefreie Kassen-App für Jahrmärkte, Vereinsfeste, Ausschankwagen und Weihnachtsmärkte.**  
> Entwickelt von [byte & Handwerk](https://byteundhandwerk.de) – Digitalisierung mit Biss.

---

## 🎯 Idee & Zielgruppe

**StandKassePro** ersetzt komplizierte Kassensysteme durch eine einfache, intuitive Tablet-App:  
Artikel antippen → Gesamtbetrag sehen → kassieren → fertig.

Konzipiert für:
- Jahr- und Weihnachtsmärkte
- Vereins- und Schulfeste
- Foodtrucks, Imbiss- und Ausschankwagen
- Pop-Up-Verkäufe, Sportheim-Events

Kein Registrierungszwang, keine Cloud, keine Werbung – **einfach kassieren.**

---

## 🧩 Hauptfunktionen

| Kategorie | Beschreibung |
|------------|---------------|
| 💰 **Verkaufsvorgang** | Artikel antippen, Warenkorb anzeigen, Summe berechnen, bar oder extern per Karte kassieren |
| 🧾 **Artikelverwaltung** | Preise, Farben, Icons und Kategorien individuell anpassbar |
| 🔄 **Tagesabschluss** | Tages-Reset mit Export der Verkäufe (CSV-Datei) |
| 📊 **Statistik** | Umsatz- und Verkaufsauswertung direkt auf dem Gerät |
| 🌓 **Offline & Dark Mode** | Kein Internet nötig, optimal für Outdoor-Betrieb |
| 🧮 **Exakter Kassenrechner** | BigDecimal-Genauigkeit, saubere Rundung (HALF_UP) |
| 🖨️ **(Optional)** Bon-Druck via Bluetooth-Drucker (ESC/POS-Standard) |

---

## ⚖️ Rechtlicher Hinweis

> StandKassePro ist **keine zertifizierte Registrierkasse im Sinne der KassenSichV**.  
> Sie dient ausschließlich der **vereinfachten Abrechnung auf zeitlich begrenzten Veranstaltungen**  
> (z. B. Jahr- oder Weihnachtsmärkte, Vereins- und Straßenfeste).
>
> Kein GoBD-Export, keine TSE-Pflicht.  
> Für dauerhaft stationäre Verkaufsstellen oder Umsätze über 100 000 € pro Jahr nicht geeignet.

---

## 🛠️ Tech-Stack

- **Sprache:** Kotlin
- **UI:** Jetpack Compose (Material 3)
- **Architektur:** MVVM + Repository Pattern
- **DI:** Hilt
- **Persistenz:** Room Database + DataStore
- **Testing:** JUnit5 / Compose UI Tests
- **Build:** Gradle KTS + GitHub Actions (CI mit Lint, Detekt & Tests)

---

## 📂 Projektstruktur