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
   - Ergänze die `Task`-Entity:
      - Schreibe `private LocalDate dueDate;` und beobachte, wie Copilot die Getter, Setter und andere Methoden ergänzt.
   - Nutze Kommentare, um Felder wie `priority` zu ergänzen:
     ```java
     // Add a priority field for tasks
     ```
2. **Klasse generieren lassen:**
   - Schreibe im Controller eine Methode:
     ```java
     // Add a method to find tasks by status
     ```
   - Copilot schlägt automatisch eine passende Methode vor.
3. **Chat verwenden:**
   - Frage im Copilot Chat:
      - „Wie funktioniert die Annotation `@Entity` in JPA?“
      - „Welche Vorteile hat `@Repository`?“
4. **Inline-Chat-Funktion:**
   - Frage innerhalb einer Repository-Methode:
     ```java
     // Explain the purpose of this custom query
     ```
5. **Javadoc generieren lassen:**
   - Generiere eine Javadoc für die Methode `getAllTasks()` im `TaskController`.
6. **Unit-Test generieren:**
   - Schreibe einen Kommentar:
     ```java
     // Write a test for getAllTasks()
     ```
   - Lasse Copilot automatisch eine Testmethode erstellen.
7. **Code Review:**
   - Lass Copilot die Methode `getAllTasks()` prüfen und Vorschläge zur Optimierung geben.
8. **Refactoring:**
   - Wähle eine längere Methode (z. B. eine neue `updateTask()`-Methode) und frage Copilot nach einer verbesserten Version.

---

#### **1.3 Fortgeschrittene Anwendungen**
1. **Repository-Queries erweitern:**
   - Schreibe eine benutzerdefinierte Query:
     ```java
     // Find tasks by completion status
     List<Task> findByCompleted(boolean completed);
     ```
   - Copilot ergänzt die Methode automatisch.
2. **Reguläre Ausdrücke:**
   - Lasse einen regulären Ausdruck für die Validierung von `title` generieren:
     ```java
     // Validate that the title contains only letters and spaces
     ```
3. **Algorithmus erklären:**
   - Füge eine Methode zur Priorisierung von Tasks hinzu:
     ```java
     // Sort tasks by due date and priority
     ```
   - Frage Copilot nach einer Erklärung der Logik.

---

### **2. Weiter in VSCode**
#### **2.1 Verbesserte Integration**
- Demonstriere die Code-Vervollständigung in VSCode:
   - Ergänze eine Methode für den `PUT`-Endpunkt:
     ```java
     // Update an existing task
     ```
   - Copilot generiert den Code.

#### **2.2 Skript generieren**
1. **Bash-Skript:**
   - Schreibe einen Kommentar:
     ```bash
     # Create a Bash script to monitor the system load
     ```
   - Copilot generiert ein passendes Skript.
2. **Übersetzen und Ausführen:**
   - Übersetze das Bash-Skript nach Python und lasse es ausführen:
     ```python
     # Python equivalent for monitoring system load
     ```
   - Demonstriere die automatische Fehlerbehebung durch Copilot.

---

### **3. GitHub Copilot CLI**
1. **CLI-Integration zeigen:**
   - Generiere ein Shell-Skript direkt in der CLI:
     ```bash
     # Generate a script to check disk usage
     ```
   - Lasse Copilot den Code optimieren.

2. **Parameter hinzufügen:**
   - Ergänze ein bestehendes Skript mit zusätzlichen Optionen, z. B. für spezifische Verzeichnisse:
     ```bash
     # Add options to specify a directory
     ```

---

## **Repository-Struktur**
```plaintext
copilot-workshop/
├── src/
│   ├── main/
│   │   ├── java/com/example/tasks/
│   │   │   ├── model/
│   │   │   │   └── Task.java
│   │   │   ├── repository/
│   │   │   │   └── TaskRepository.java
│   │   │   ├── controller/
│   │   │   │   └── TaskController.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql
│   └── test/
│       ├── java/com/example/tasks/
│       │   └── TaskControllerTest.java
├── scripts/
│   └── system_monitor.sh
├── README.md
