# GitHub Copilot Workshop – Hands-On Drehbuch

## Einführung
Willkommen zum Hands-On Teil des GitHub Copilot Workshops! Dieses Repository begleitet die praktische Demonstration der Features von GitHub Copilot in IntelliJ, VSCode und der Kommandozeile.

---

## **Agenda**

### **1. Start mit IntelliJ**
#### **1.1 Einrichtung & Einstellungen**
- Plugin-Installation (GitHub Copilot Plugin).
- Einstellungen anpassen (Preferences > Plugins > GitHub Copilot).
- Nightly-Version aktivieren (falls verfügbar).
- Tray-Icon nutzen (Feedback, Aktivierung).

#### **1.2 GitHub Copilot: Basics**
1. **Auto-Completion:**
   - Beispiel: Erstellen einer Klasse `User`.
   - Demonstration: Kontextbasierte Vorschläge mit `Tab` annehmen.
2. **Klasse generieren lassen:**
   - Kommentar: `// Create a class to manage user accounts`.
   - Copilot vervollständigt Klasse und Methoden.
3. **Chat verwenden:**
   - Frage: „Wie funktioniert eine HashMap in Java?“
4. **Inline-Chat-Funktion:**
   - Markierung einer Methode, z.B.: „Wie kann ich die Effizienz dieser Methode verbessern?“
5. **Javadoc generieren lassen:**
   - Beispiel-Methode: `calculateSum`.
   - Copilot schlägt passende Javadoc-Kommentare vor.
6. **Unit-Test generieren:**
   - Beispiel-Methode: `int add(int a, int b)`.
   - Automatische Generierung von Tests.
7. **Code Review:**
   - Analyse einer längeren Methode.
   - Vorschläge zur Verbesserung und Optimierung.
8. **Refactoring:**
   - Copilot optimiert eine vorhandene Methode.

#### **1.3 Fortgeschrittene Anwendungen**
1. **Reguläre Ausdrücke:**
   - Komplexen Regex erklären lassen.
   - Vereinfachung in lesbare Form.
2. **Code-Übersetzung:**
   - Beispiel: Übersetzung eines Python-Skripts in JavaScript.
3. **Algorithmus erklären:**
   - Beispiel: Quicksort-Algorithmus.
   - Erklärung der Logik durch Copilot.

---

### **2. Weiter in VSCode**
#### **2.1 Verbesserte Integration**
- Demonstration der verbesserten Features in VSCode.
- Zeigen des Terminals und interaktiver Nutzung.

#### **2.2 Skript generieren**
1. **Bash-Skript:**
   - Kommentar: `# Create a Bash script to monitor system load`.
   - Copilot generiert ein Skript.
2. **Übersetzen und Ausführen:**
   - Bash-Skript nach Python übersetzen.
   - Fehler bei der Ausführung automatisch beheben lassen.

---

### **3. GitHub Copilot CLI**
1. **CLI-Integration zeigen:**
   - Demonstration der Nutzung direkt in der Kommandozeile.
2. **Beispiele:**
   - Generierung eines Shell-Skripts (`disk_usage.sh`).
   - Optimierung durch Parameter und Optionen.

---

## **Repository-Struktur**
```plaintext
copilot-workshop/
├── src/
│   ├── java/
│   │   └── BasicExamples.java
│   └── python/
│       └── sample_script.py
├── tests/
│   └── unit_tests.java
├── scripts/
│   └── system_monitor.sh
└── README.md
