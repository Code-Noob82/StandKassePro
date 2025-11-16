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

## 🧠 Lizenzmodell

	•	Free Version: bis 15 Artikel, kein Export
	•	Pro Version (Einmalzahlung): unbegrenzte Artikel, CSV-Export, Themes, Bon-Druck
	•	Keine Werbung • Kein Tracking • Kein Abo

---

## 🤝 Mitwirken

Beiträge, Feedback und Tests sind willkommen!
1.	Fork das Repo
2.	Erstelle einen Feature-Branch
3.	Füge deine Änderungen hinzu
4.	Reiche einen Pull Request ein

Bitte halte dich an die bestehenden Code-Style-Guidelines (Ktlint / Detekt).

---

## 📅 Roadmap

Nachfolgend die Entwicklungsphasen von StandKassePro – klar getrennt nach Versionen, Status und geplanten Funktionen.
Diese Darstellung ist sowohl technisch sauber als auch für Nutzer gut verständlich.

🔵 v1.0.0 – MVP (Minimal Viable Product)

Status: 🔧 In Entwicklung

Ziele:
•	Basisfunktionalität für den Einsatz auf Jahrmärkten, Vereinsfesten und Ausschankwagen
•	Intuitive Bedienung, robustes Offline-Verhalten, schnelle Verkaufserfassung

Umfang:
•	Artikelverwaltung (Name, Preis, Farbe, Icon)
•	Artikel-Grid mit großen Buttons
•	Warenkorb mit Summenberechnung (BigDecimal, HALF_UP)
•	Barzahlung & externe Kartenzahlung
•	Tagesstatistik (Umsatz, Anzahl der Verkäufe)
•	Tages-Reset
•	CSV-Export (Tag/Zeitraum)
•	Undo/Storno per Long-Press
•	Dark Mode (Auto/Manuell)
•	App-Settings (Button-Größe, Headertext, Dezimalkomma)
•	Verbesserte Tablet-Layouts (Landscape/Portrait)

⸻

🟢 v1.1.0 – Pro Features

Status: ⏳ Geplant

Ziele:
•	Erweiterte Funktionalität für professionelle Standbetreiber
•	Komfortfeatures + leichte Individualisierung

Umfang:
•	Pfandartikel (steuerfrei/steuerpflichtig)
•	Preisvarianten (z. B. Bier 0,3 L / 0,5 L)
•	Erweiterte Themes + Night Mode Pro
•	Artikel duplizieren, sortieren, gruppieren
•	Optional: ESC/POS-Bon-Druck (Bluetooth)
•	Export-Optimierungen (Kategorien, Summen pro Artikel)

⸻

🟣 v1.2.0 – Payment & Komfort

Status: 💡 Idee / Konzeptphase

Ziele:
•	Professionale Zahlungsabwicklung integrieren
•	Mehr Komfort für Vereine & mobile Verkäufer

Umfang:
•	Karten-Zahlungsintegration (SumUp / Stripe Terminal)
•	Beleg-PDF mit QR-Code
•	Automatische Umsatz-Backups (lokal verschlüsselt)
•	Erweiterte Warenkorblogik (Rabatt/Pfand schneller erreichbar)

⸻

🟠 v2.0.0 – Teamkassen & Sync

Status: 🚀 Langfristige Vision

Ziele:
•	Gemeinsame Nutzung für größere Events
•	Optionaler Cloud-Sync für mehrere Tablets

Umfang:
•	Lokaler Sync zwischen mehreren Kassen (WLAN/Bluetooth)
•	Cloud-Sync (Supabase) – optional, DSGVO-konform
•	Live-Umsatzübersicht für Veranstalter
•	Rollen & Berechtigungen (Admin/Kasse/Export)

⸻

🧩 Nice-to-Have / Zukunftsideen
•	Widget für Umsatz-Überblick
•	KI-gestützte Artikel-Erstellung (Bild → Button)
•	Event-Vorlagen (Weihnachtsmarkt, Dorffest, Sportheim)
•	Mehrsprachigkeit (EN/FR/TR)
•	Kassenbuch-Export Light (kein GoBD)
•	Individuelle Schriftgrößen / Kiosk-Modus