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
        3. Lass Copilot eine längere Methode generieren und zeige wie man eine ganze Completion (mit Tab) oder nur Teile davon (mit Strg+Rechts) übernimmt. 
           ```java
          // Generate a custom toString method that outputs fields in a JSON-like format
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

2. **Javadoc generieren**
    - **Option 1:** Setze `/**` vor die Methode, um Javadoc automatisch zu generieren.
    - **Option 2:** Nutze den Command `/docs`, um Javadoc für die gesamte Klasse zu erstellen.
        - Prompt im Chat:
          ```
          Generate Javadoc for the TaskController class.
          ```
          
3. **Code analysieren und vereinfachen**
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

4. **Unit-Test generieren**
   - Nutze den Command `/tests`, um automatisch einen Unit-Test für die Methode TaskService#getTasksDueSoonComplicated zu erstellen.
   - Prompt im Chat:
     ```
     Generate a unit test for the method that fetches tasks due within the next 7 days, sorted by priority.
     ```
5. **Fehlschlagenden Unit-Test reparieren**
    - Manipuliere einen Test, um einen Fehler zu verursachen, und führe ihn aus.
    - Prompt im Chat:
      ```
      /fix Fix the failing unit test.
      ```
    - Füge den Stacktrace in den Chat ein, um den Fehlerkontext bereitzustellen.

5. **Reguläre Ausdrücke erklären und vereinfachen**

   - **Ziel:** Demonstriere, wie GitHub Copilot im normalen Chat reguläre Ausdrücke und komplette Klassen analysieren, erklären und optimieren kann.
   - **Bezug:** Die Methode `validateTaskTitle` in der Klasse `TaskValidationService` validiert Titel für Tasks mit einem regulären Ausdruck.

   #### **Schritte:**

   1. Öffne die Klasse `TaskValidationService`.
   2. Hebe die gesamte Klasse im Editor hervor.
   3. Öffne den Copilot Chat und gib den folgenden Prompt ein:
      ```
      /explain Explain the TaskValidationService class.
      ```
   4. Lass Copilot eine Übersicht über die Klasse und ihre Funktionen geben:
      - **Erklärung:** Die Klasse enthält eine Methode zur Validierung von Task-Titeln basierend auf einem regulären Ausdruck.

   #### **Regulären Ausdruck analysieren:**
   1. Markiere den regulären Ausdruck in der Methode:
      ```java
      String regex = "^[A-Za-z][A-Za-z0-9 _-]{4,49}$";
      ```
   2. Gib im Copilot Chat den Prompt ein:
      ```
      Explain this regular expression.
      ```
   3. Lass Copilot den Ausdruck erklären:
      - **Erklärung:** Der reguläre Ausdruck validiert Titel, die mit einem Buchstaben beginnen, zwischen 5 und 50 Zeichen lang sind, und nur Buchstaben, Zahlen, Leerzeichen, Unterstriche oder Bindestriche enthalten.

   #### **Regulären Ausdruck vereinfachen:**
   1. Gib im Copilot Chat den folgenden Prompt ein:
      ```
      /simplify Simplify this regular expression while keeping it functional.
      ```
   2. Überprüfe den Vorschlag von Copilot, z. B.:
      ```java
      String regex = "^[\\w _-]{5,50}$";
      ```
   3. Diskutiere die Vereinfachung:
      - Der optimierte Ausdruck ist kürzer, erlaubt jedoch zusätzliche Eingaben wie Zahlen am Anfang des Titels. Prüfe, ob diese Änderung akzeptabel ist.

   #### **Erklärung:**
   - Diskutiere die Vor- und Nachteile der Optimierung:
      - **Ursprünglich:** Striktere Validierung, aber komplizierter zu lesen.
      - **Optimiert:** Kürzer und einfacher, aber potenziell weniger restriktiv.
   - Betone, wie Copilot hilft, den richtigen Balancepunkt zwischen Lesbarkeit und Funktionalität zu finden.

   #### **Zusatzoption:**
   - Frage im Chat:
     ```
     Suggest additional patterns to validate task titles.
     ```
   - Zeige, wie Copilot alternative Ansätze vorschlägt, um die Validierungslogik weiter anzupassen.

   **Hinweis:** Dieser Case zeigt, wie reguläre Ausdrücke praktisch für die Validierung von Eingaben in der Task-Entität verwendet werden können und wie Copilot bei der Analyse und Optimierung hilft.


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

#### **2.4 Integration mit dem Terminal**

1. **Bash-Skript `system_check.sh` generieren, speichern und erweitern**

   - **Ziel:** Generiere ein Bash-Skript, speichere es im Dateisystem, mache es ausführbar und erweitere es.
   - **Schritte:**
     1. Öffne den Copilot Chat und gib den folgenden Prompt ein:
        ```
        Schreibe ein Bash-Skript, das eine grundlegende Systemüberprüfung durchführt. 
        Das Skript sollte:
        - Die CPU- und Speicherauslastung überprüfen,
        - Prozesse identifizieren, die die meisten Ressourcen verbrauchen,
        - Den Speicherplatz aller eingebundenen Dateisysteme überwachen,
        - Kritische Meldungen und Fehlermeldungen in den Systemlogs (z.B. aus syslog oder dmesg) zählen und anzeigen,
        - Eine Zusammenfassung dieser Metriken zur schnellen Analyse ausgeben.
        ```
     2. Speichere das generierte Bash-Skript aus dem Chat über **Insert into new File** als `system_check.sh` im Dateisystem.
     3. Der Chat zeigt automatisch den Befehl an, um das Skript ausführbar zu machen:
        ```bash
        chmod +x system_check.sh
        ```
        - Klicke auf **Insert Into Terminal**, um den Befehl direkt im Terminal auszuführen.
     4. Führe das Skript aus:
        ```bash
        ./system_check.sh
        ```
     5. **Skript erweitern:** Öffne den Inline-Chat (Strg+I) und gib folgenden Prompt ein:
        ```
        Übersetze alle echo-Ausgaben im Skript ins Englische.
        ```
     6. Überprüfe die Änderungen und speichere das aktualisierte Skript.

2. **Bash-Skript nach Python übersetzen**
   - **Ziel:** Generiere ein äquivalentes Python-Skript basierend auf dem Bash-Skript.
   - **Schritte:**
     1. Öffne den Copilot Chat und gib folgenden Prompt ein:
        ```
        Übersetze das folgende Bash-Skript in ein Python-Skript.
        ```
     2. Überprüfe die generierte Python-Version und speichere sie als `system_check.py`.

3. **Fehler in Python-Skript beheben**
   - **Ziel:** Simuliere einen einfachen Fehler und lasse ihn automatisch beheben.
   - **Schritte:**
     1. Baue absichtlich einen Fehler in das Python-Skript ein, z. B. ändere das letzte `print`-Statement zu `pprint`.
     2. Führe das Skript aus und beobachte die Fehlermeldung im Terminal.
     3. Öffne den Copilot Chat und gib den folgenden Prompt ein:
        ```
        @terminal /explain Can you fix the problem?
        ```
     4. Überprüfe die Antwort von Copilot im Chat.
        - Klicke auf **Apply in Editor**, um den vorgeschlagenen Fix in das Skript zu übernehmen.
     5. Übernimm die Änderung im Editor durch **Apply**.
     6. Führe das Skript erneut aus, um sicherzustellen, dass der Fehler behoben wurde.

   **Erklärung:**
   - Zeige, wie Copilot den Fehler analysiert und basierend auf der Fehlermeldung einen passenden Fix vorschlägt.
   - Diskutiere die Vorteile dieser Funktion bei der schnellen Fehlerbehebung in Skripten und Anwendungen.

#### **2.5 SQL-Generierung aus DDL**

1. **SQL für komplexe Abfragen generieren**

    - **Ziel:** Zeige, wie GitHub Copilot mit einer bestehenden Datenbankstruktur (DDL) komplexe SQL-Abfragen erstellen kann.
    - **Schritte:**
        1. Öffne die Datei `sql/create.sql`, die die Tabellenstruktur enthält.
        2. Hebe die Datei über das **+ Symbol** im Copilot Chat in den Kontext (manuelles Hinzufügen der Datei).
        3. Gib im Copilot Chat folgenden Prompt ein:
           ```
           Write an SQL query to fetch all tasks along with their project name, assigned user, and the number of comments.
           ```
        4. Überprüfe die generierte Abfrage und kopiere sie in eine neue Datei, z. B. `sql/task_report.sql`.

   #### **Optional: Abfrage anpassen**
    - Gib im Chat folgenden Prompt ein:
      ```
      Modify the query to include only tasks that are not completed and sort them by project name and priority.
      ```
    - Übernehme die angepasste Abfrage und speichere sie ab.

2. **Erklärung:**
    - Zeige, wie Copilot basierend auf der DDL-Datei komplexe SQL-Abfragen generiert, ohne dass die gesamte Datei in den Chat kopiert werden muss.
    - Diskutiere, wie die Abfragen durch kurze Prompts verfeinert und angepasst werden können.
    - Betone den Zeitvorteil bei der Erstellung komplexer SQL-Statements, insbesondere bei umfangreichen Tabellenstrukturen.

### **3. GitHub Copilot CLI**

1. **CLI-Kommandos mit Copilot optimieren**
   - **Ziel:** Demonstriere, wie Copilot CLI komplexe Aufgaben in der Kommandozeile erleichtert.

   #### **Erster Versuch: Suche nach Java-Dateien**
   1. Wechsel in die **WSL2 Ubuntu Shell**.
   2. Weise kurz darauf hin, dass die GitHub Copilot CLI separat installiert werden muss, und verweise auf die Dokumentation von GitHub Copilot CLI (falls benötigt).
   3. Starte die GitHub Copilot CLI mit dem Alias:
      ```bash
      ghcs
      ```
   4. Die CLI fragt: **What would you like the shell command to do?**
      - Gib den folgenden Prompt ein:
        ```
        Finde alle Java files, in diesem und allen Unterverzeichnissen, absteigend sortiert nach Größe, in denen die Zeichenkette String zu finden ist.
        ```
   5. Wähle **Execute command**, um das vorgeschlagene Kommando auszuführen.
   6. Überprüfe die Ergebnisse und diskutiere die Nützlichkeit von Copilot CLI bei der Erstellung komplexer Shell-Kommandos.

   #### **Zweiter Versuch: Docker-Container anzeigen und verfeinern**
   1. Starte erneut die GitHub Copilot CLI:
      ```bash
      ghcs
      ```
   2. Prompt direkt eingeben:
      ```
      Zeige alle laufenden Docker-Container.
      ```
   3. Wähle **Execute command**, um die initiale Liste der laufenden Docker-Container anzuzeigen.
   4. Verfeinere das Kommando mit **Revise command**:
      ```
      Zeige alle laufenden Docker-Container, die "ppi" im Namen haben.
      ```
   5. Führe das überarbeitete Kommando erneut aus, indem du **Execute command** auswählst.
   6. Überprüfe die Ergebnisse und betone die Flexibilität der CLI, komplexe Kommandos schrittweise zu optimieren.

   #### **Erklärung:**
   - Zeige, wie Copilot CLI in verschiedenen Kontexten nützlich ist, von Dateisuche bis Docker-Management.
   - Diskutiere, wie die Verfeinerung über **Revise command** den Workflow iterativ verbessert.
   - Betone die Vorteile der automatisierten Generierung für wiederkehrende oder komplexe Aufgaben.
