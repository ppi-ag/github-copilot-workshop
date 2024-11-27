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

### **2. Weiter in VSCode**

#### **2.1 Orientierung und Einrichtung**
1. **GitHub Copilot Extensions:**
   - Öffne den Extension Marketplace in VSCode und suche nach „GitHub Copilot“.
   - Zeige die beiden Extensions:
     - **GitHub Copilot**
     - **GitHub Copilot Chat**
   - Hinweise:
     - Aktiviere Auto-Update für beide Extensions.
     - Zeige die Option „Switch to Release Version“ bzw. „Switch to Pre-Release Version“.
     - Weise auf die beeindruckenden **22 Millionen Installationen** hin, um die Verbreitung und Beliebtheit zu verdeutlichen.

2. **Tray-Icon und Navigation:**
   - Zeige das GitHub Copilot Tray-Icon unten rechts in der Statusleiste.
   - Navigiere von dort aus zu:
     - **Settings:** Einstellungen für Copilot anpassen.
     - **Keyboard Settings:** Zeige, wie Tastenkombinationen konfiguriert werden können.
     - **Chat:** Öffne den Chat direkt über das Tray-Icon.

3. **Settings und Features:**
   - Öffne die Einstellungen für GitHub Copilot und führe die Teilnehmer durch einige interessante Optionen:
     - **Experimental Features:** Zeige, welche neuen Funktionen getestet werden können.
     - **Autocompletion Settings:** Passe Verhalten und Vorschläge von Copilot an.
   - **Besonderer Hinweis:** 
     - Erkläre, wie eine `.github/copilot-instructions.md` Datei verwendet werden kann, um benutzerdefinierte Anweisungen für Copilot hinzuzufügen. Dies ist besonders nützlich für projektspezifische Anforderungen.

#### **2.2 Verbesserte Integration**

1. **Neuen komplexen Endpunkt generieren und refactoren**

   - **Ziel:** Erstelle einen Endpunkt, der Aufgaben nach ihrer Priorität gruppiert und innerhalb jeder Prioritätsgruppe nach ihrem Fälligkeitsdatum sortiert.

   #### **Schritte:**
   1. Öffne die Klasse `TaskController`.
   2. Gib den folgenden Prompt im Copilot Chat ein:
      ```
      Create a REST endpoint to group tasks by priority and sort them by due date within each priority group.
      ```
   3. Überprüfe den generierten Code im Chat und wähle **Apply in Editor**, um die Methode in die Klasse `TaskController` einzufügen.
   4. Übernehme den generierten Code im Editor, indem du auf **Accept Changes** klickst.

   #### **Refactoring:**
   1. Öffne die Methode im Editor und drücke `Strg+I`, um den Inline-Chat zu öffnen.
   2. Gib den folgenden Prompt ein:
      ```
      Avoid using Stream API.
      ```
   3. Überprüfe den Refactoring-Vorschlag von Copilot und übernehme die Änderungen.

   #### **Erklärung:**
   - Zeige den ursprünglichen Code mit der Stream-API und den refactorisierten Code ohne Streams.
   - Diskutiere die Vorteile und Nachteile der jeweiligen Ansätze:
     - **Stream-API:** Kürzer und ausdrucksstärker.
     - **Ohne Streams:** Traditionelle Schleifen, die manchmal einfacher zu debuggen sind.

#### **2.3 Commit-Nachrichten automatisch generieren**

1. **Ziel:** Zeige, wie GitHub Copilot eine Commit-Nachricht basierend auf den Änderungen im Repository vorschlägt.

   #### **Schritte:**
   1. Nimm Änderungen am Code vor, z. B. füge den neuen Endpunkt hinzu oder refactore eine Methode.
   2. Öffne das Git-Panel in VSCode (`Strg+Shift+G`) oder die Source Control Ansicht.
   3. Wähle die geänderten Dateien aus und klicke auf **Stage Changes**.
   4. Gehe in das Textfeld für die Commit-Nachricht und gib einen Kommentar ein, z. B. `Generate commit message`.
   5. Der Vorschlag von Copilot erscheint automatisch basierend auf den Änderungen.
   6. Überprüfe die vorgeschlagene Nachricht und übernimm sie, falls sie passend ist.

   #### **Erklärung:**
   - Diskutiere, wie Copilot den geänderten Code analysiert und eine präzise Commit-Nachricht vorschlägt.
   - Betone, dass dies besonders nützlich ist, um konsistente und aussagekräftige Commit-Nachrichten zu schreiben.

