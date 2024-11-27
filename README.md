# GitHub Copilot Workshop – Hands-On Drehbuch

## Einführung
Willkommen zum Hands-On Teil des GitHub Copilot Workshops! Dieses Repository begleitet die praktische Demonstration der Features von GitHub Copilot in IntelliJ, VSCode und der Kommandozeile.

---

## **Agenda**

### **1. Start mit IntelliJ**

#### **1.1 Einrichtung & Einstellungen**
1. Plugin-Installation (GitHub Copilot Plugin).
2. Einstellungen anpassen (Preferences > Plugins > GitHub Copilot).
3. Nightly-Version aktivieren (falls verfügbar).
4. Tray-Icon nutzen (Feedback, Aktivierung).

#### **1.2 GitHub Copilot: Basics**

1. **Auto-Completion**
    - Ergänze die `Task`-Entity um folgende Felder:
        - `dueDate` und `priority`.
    - **Schritte:**
        1. Tippe die Felder direkt in den Code und beobachte, wie Copilot Auto-Completion-Vorschläge macht.
        2. Ergänze ein weiteres Feld, indem du zuerst einen Kommentar hinzufügst, z. B.:
           ```java
           // Add a priority field for tasks
           ```

    - **Vorschläge im Menü „GitHub Copilot“ überprüfen:**
        - Während du die Felder hinzufügst, kannst du im Menü „GitHub Copilot“ alternative Vorschläge ansehen.

2. **Chat verwenden**
    - Verwende den Copilot Chat, um automatisch die Endpunkte für **Anlegen**, **Ändern** und **Löschen** von Tasks zu erstellen.
    - Prompt im Chat:
      ```
      Generate REST endpoints for creating, updating, and deleting tasks in TaskController.
      ```
    - Überprüfe die generierten Methoden und passe sie bei Bedarf an.

3. **Benutzerdefinierter Endpunkt generieren**
    - Verwende den Copilot Chat, um einen Endpunkt zu erstellen, der Tasks basierend auf ihrem Status (`completed`) filtert.
    - Prompt im Chat:
      ```
      Create a REST endpoint in TaskController to find tasks by their completion status.
      ```
    - Ergänze die `TaskRepository`-Schnittstelle um die erforderliche Methode:
      ```java
      List<Task> findByCompleted(boolean completed);
      ```

4. **Technische Fragen stellen**
    - Verwende den Copilot Chat, um spezifische Fragen zu Annotationen oder Framework-Details zu stellen.
    - Beispiele:
        - Prompt: „Explain how the @Entity annotation works in JPA.“
        - Prompt: „What is the difference between @RestController and @Controller in Spring?“

---

#### **1.3 GitHub Copilot: Advanced**

1. **Komplexere Methode generieren**
    - Generiere eine Methode, die alle Tasks innerhalb der nächsten 7 Tage filtert und nach Priorität sortiert.
    - Prompt im Chat:
      ```
      Create a method in TaskController to fetch tasks due within the next 7 days, sorted by priority.
      ```

2. **Unit-Test generieren**
    - Nutze den Command `/tests`, um automatisch einen Unit-Test für die generierte Methode zu erstellen.
    - Prompt im Chat:
      ```
      Generate a unit test for the method that fetches tasks due within the next 7 days, sorted by priority.
      ```

3. **Javadoc generieren**
    - **Option 1:** Setze `/**` vor die Methode, um Javadoc automatisch zu generieren.
    - **Option 2:** Nutze den Command `/docs`, um Javadoc für die gesamte Klasse zu erstellen.
        - Prompt im Chat:
          ```
          Generate Javadoc for the TaskController class.
          ```

4. **Code analysieren und vereinfachen**
    - Beziehe dich auf die Methode `getTasksDueSoonComplicated()` in der Klasse `TaskService`, die bewusst kompliziert geschrieben wurde.

   #### **Code erklären**
    - Markiere die Methode `getTasksDueSoonComplicated()` im Editor.
    - Prompt im Chat:
      ```
      Explain the method getTasksDueSoonComplicated in TaskService.
      ```
    - Lass Copilot die Methode analysieren und eine Schritt-für-Schritt-Erklärung der Logik liefern:
        - Filterung von Aufgaben basierend auf dem Fälligkeitsdatum.
        - Sortierung der Aufgaben nach Priorität.
        - Nutzung von Schleifen und Comparatoren.

   #### **Code vereinfachen**
    - Wähle die Methode `getTasksDueSoonComplicated()` im Editor aus und öffne den Inline-Chat.
    - Prompt im Inline-Chat:
      ```
      /simplify Refactor getTasksDueSoonComplicated to use the Stream API.
      ```
    - Überprüfe den Vorschlag von Copilot und wende ihn an, um die Methode zu vereinfachen, indem Streams und Lambdas verwendet werden.

   **Erklärung:**
    - Zeige den Unterschied zwischen der ursprünglichen und der vereinfachten Version.
    - Betone, wie Copilot den Code wartbarer und besser lesbar macht.

5. **Fehlschlagenden Unit-Test reparieren**
    - Manipuliere einen Test, um einen Fehler zu verursachen, und führe ihn aus.
    - Prompt im Chat:
      ```
      /fix Fix the failing unit test.
      ```
    - Füge den Stacktrace in den Chat ein, um den Fehlerkontext bereitzustellen.

---

### **2. Weiter in VSCode**

#### **2.1 Verbesserte Integration**
1. Demonstriere die Code-Vervollständigung und das Terminal in VSCode.
2. Ergänze einen neuen `PUT`-Endpunkt.

#### **2.2 Skript generieren**
1. Schreibe einen Kommentar wie:
   ```bash
   # Create a Bash script to monitor system load
