# GitHub Copilot Workshop – Hands-On Drehbuch

---

## **1. IntelliJ**

### **1.1 Einrichtung & Einstellungen**

1. Plugin-Installation (GitHub Copilot Plugin).

2. Einstellungen anpassen (Preferences > Plugins > GitHub Copilot).
    - Standard-Shortcuts sind teilweise mit deutscher Tastatur nicht nutzbar

3. Nightly-Version aktivieren (falls verfügbar).
    - beim Start von IntelliJ ggf. Fehler "auf Datei .../appdata/... kann nicht zugegriffen werden", fix: Datei löschen

4. Tray-Icon nutzen (Feedback, Aktivierung).

### **Code-Completion**

#### **Completion über Kommentar oder einfach lostippen**

- Ergänze die `Task`-Entity um die Felder `dueDate` und `priority`.
    1. Tippe die Felder direkt in den Code und beobachte, wie Copilot Auto-Completion-Vorschläge macht.

    2. Ergänze ein weiteres Feld, indem du zuerst einen Kommentar hinzufügst, z. B.:
       ```java
       // Add a priority field for tasks
       ```

#### **Completion durch Wort-für-Wort**

- Wort-für-Wort-completion (Strg-Rechts):
- Line-completion (Strg-Alt-Enter):

```java
TaskValidationService
        ...

public boolean validateAllTaskFields(Task task) {
    return task.getDescription().matches("^[A-Za-z0-9 _-]{4,49}$")
            && validateTaskTitle(task.getTitle())
            && task.getId() != null;
}
```

- Vorschläge im Menü „GitHub Copilot“ überprüfen:
    - Open Completions (Strg-Alt-Shift-Minus)

#### **Completion mit Chat**

- im TaskController die Endpunkte für **Anlegen**, **Ändern** und **Löschen** von Tasks erstellen.
    - Prompt im Chat:

```
      Generate REST endpoints for creating, updating, and deleting tasks in TaskController.
```

- Endpunkt zu erstellen, der Tasks basierend auf ihrem Status (`completed`) filtert.
    - Prompt im Chat:

 ```
 Create a REST endpoint in TaskController to find tasks by their completion status.
 ```

- Ergänze die `TaskRepository`-Schnittstelle um die erforderliche Methode:

   ```java
   List<Task> findByCompleted(boolean completed);
   ```

- alle Tasks innerhalb der nächsten 7 Tage filtern und nach Priorität sortieren.
    - Prompt im Chat:
      ```
      Create a method in TaskController to fetch tasks due within the next 7 days, sorted by priority.
      ```

### Code analysieren und vereinfachen

- Methode `getTasksDueSoonComplicated()` in der Klasse `TaskService`
    - Code erklären
        - Markiere die Methode `getTasksDueSoonComplicated()` im Editor.
        - Prompt im Chat:
          ```
          Explain the method getTasksDueSoonComplicated in TaskService.
          ```
        - Lass Copilot die Methode analysieren und eine Schritt-für-Schritt-Erklärung der Logik liefern:
            - Filterung von Aufgaben basierend auf dem Fälligkeitsdatum.
            - Sortierung der Aufgaben nach Priorität.
            - Nutzung von Schleifen und Comparatoren.

    - Code vereinfachen

- Wähle die Methode `getTasksDueSoonComplicated()` im Editor aus und öffne den Inline-Chat.
- Prompt im Inline-Chat:
  ```
  /simplify Refactor getTasksDueSoonComplicated to use the Stream API.
  ```

### Unit-Tests

- Nutze den Command `/tests`, um automatisch einen Unit-Test für die generierte Methode zu erstellen.
    - Prompt im Chat:

```
        Generate a unit test for the method that fetches tasks due within the next 7 days, sorted by priority.
```

#### Tests reparieren

- Nehme den Test TaskValidationServiceTest und führe ihn aus.
- Füge den Stacktrace in den Chat ein, um den Fehlerkontext bereitzustellen.
  ```
  /fix Fix the failing unit test.
  ```

### Javadoc

- **Option 1:** Setze `/**` vor die Methode, um Javadoc automatisch zu generieren.
- **Option 2:** Nutze den Command `/docs`, um Javadoc für die gesamte Klasse zu erstellen.
    - Prompt im Chat:
      ```
      Generate Javadoc for the TaskController class.
      ```

## Technische Fragen stellen

- Verwende den Copilot Chat, um spezifische Fragen zu Annotationen oder Framework-Details zu stellen.
- Beispiele:
    - Prompt: „Explain how the @Entity annotation works in JPA.“
    - Prompt: „What is the difference between @RestController and @Controller in Spring?“

### Reguläre Ausdrücke

#### Erklären

- Reguläre Ausdrücke in `TaskValidationService.validateTaskTitle`

```
/explain Explain the TaskValidationService class.
```

- Regulären Ausdruck analysieren
    - Markiere den regulären Ausdruck in der Methode:

```java
String regex = "^[A-Za-z][A-Za-z0-9 _-]{4,49}$";
```

Prompt im Chat:

```
Explain this regular expression.
```

#### Vereinfachen

- Gib im Copilot Chat den folgenden Prompt ein:

 ```
 /simplify Simplify this regular expression while keeping it functional.
 ```

- Überprüfe den Vorschlag von Copilot, z. B.:

 ```java
 String regex = "^[\\w _-]{5,50}$";
 ```

- regex101.com nicht vergessen

- Erklärungen zu Regex auch interessant z.B. "wie funktionieren lookaheads?"

### **Zusatzoption:**

- Frage im Chat:
  ```
  Suggest additional patterns to validate task titles.
  ```

---

## **2. Weiter in VSCode**

### **2.1 Orientierung und Einrichtung**

1. **Installation:**
    - **GitHub Copilot**
    - **GitHub Copilot Chat**
    - Hinweise:
        - Auto-Update.
        - Zeige die Option „Switch to Release Version“ bzw. „Switch to Pre-Release Version“.

2. **Tray-Icon**

3. **Settings und Features:**
    - Einstellungen
        - **Experimental Features:** Zeige, welche neuen Funktionen getestet werden können.
        - **Autocompletion Settings:** Passe Verhalten und Vorschläge von Copilot an.
    - **Besonderer Hinweis:**
        - Erkläre, wie eine `.github/copilot-instructions.md` Datei verwendet werden kann, um benutzerdefinierte Anweisungen
          - projektspezifische Anforderungen.
          - "immer java"
          - "immer englisch"
          - "stream api bevorzugen"

### **2.2 Verbesserte Integration**

1. **Neuen komplexen Endpunkt generieren und refactoren**

   ### **Schritte:**
    1. Öffne die Klasse `TaskController`.
    2. Gib den folgenden Prompt im Copilot Chat ein:
       ```
       Create a REST endpoint to group tasks by priority and sort them by due date within each priority group.
       ```

   ### **Refactoring:**
    1. Öffne die Methode im Editor und drücke `Strg+I`, um den Inline-Chat zu öffnen.
    2. Gib den folgenden Prompt ein:
       ```
       Avoid using Stream API.
       ```
    3. Überprüfe den Refactoring-Vorschlag von Copilot und übernehme die Änderungen.

### **2.3 Commit-Nachrichten automatisch generieren**

1. **Ziel:** Zeige, wie GitHub Copilot eine Commit-Nachricht basierend auf den Änderungen im Repository vorschlägt.

   ### **Schritte:**
    1. Nimm Änderungen am Code vor, z. B. füge den neuen Endpunkt hinzu oder refactore eine Methode.
    2. Öffne das Git-Panel in VSCode (`Strg+Shift+G`) oder die Source Control Ansicht.
    3. Wähle die geänderten Dateien aus und klicke auf **Stage Changes**.
    4. Gehe in das Textfeld für die Commit-Nachricht und gib einen Kommentar ein, z. B. `Generate commit message`.
    5. Der Vorschlag von Copilot erscheint automatisch basierend auf den Änderungen.
    6. Überprüfe die vorgeschlagene Nachricht und übernimm sie, falls sie passend ist.

### **2.4 Integration mit dem Terminal**

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
        2. Speichere das generierte Bash-Skript aus dem Chat über **Insert into new File** als `system_check.sh` im
           Dateisystem.
        3. Der Chat zeigt automatisch den Befehl an, um das Skript ausführbar zu machen:
           ```bash
           chmod +x system_check.sh
           ```
            - Klicke auf **Insert Into Terminal**, um den Befehl direkt im Terminal auszuführen.
        4. Führe das Skript aus:
           ```bash
           ./system_check.sh
           ```
        5. **Skript erweitern:** open copilot edits (Strg-Shift-I) und gib folgenden Prompt ein:
           ```
           Übersetze alle echo-Ausgaben im Skript ins Englische.
           ```

2. **Bash-Skript nach Python übersetzen**
    - **Ziel:** Generiere ein äquivalentes Python-Skript basierend auf dem Bash-Skript.
    - **Schritte:**
        1. Öffne den Copilot Chat und gib folgenden Prompt ein:
           ```
           Übersetze das folgende Bash-Skript in ein Python-Skript.
           ```
        2. Überprüfe die generierte Python-Version und speichere sie als `system_check.py`.
           ... und ausführen

3. **Fehler in Python-Skript beheben**
    - **Ziel:** Simuliere einen einfachen Fehler und lasse ihn automatisch beheben.
    - **Schritte:**
        1. Baue absichtlich einen Fehler in das Python-Skript ein, z. B. ändere das letzte `print`-Statement zu
           `pprint`.
        2. Führe das Skript aus und beobachte die Fehlermeldung im Terminal.
        3. Öffne den Copilot Chat und gib den folgenden Prompt ein:
           ```
           @terminal /explain Can you fix the problem?
           ```
        4. Überprüfe die Antwort von Copilot im Chat.
            - Klicke auf **Apply in Editor**, um den vorgeschlagenen Fix in das Skript zu übernehmen.
        5. Übernimm die Änderung im Editor durch **Apply**.
        6. Führe das Skript erneut aus, um sicherzustellen, dass der Fehler behoben wurde.

### **2.5 SQL-Generierung aus DDL**

1. **SQL für komplexe Abfragen generieren**

    - **Ziel:** Zeige, wie GitHub Copilot mit einer bestehenden Datenbankstruktur (DDL) komplexe SQL-Abfragen erstellen
      kann.
    - **Schritte:**
        1. Öffne die Datei `sql/create.sql`, die die Tabellenstruktur enthält.
        2. Hebe die Datei über das **+ Symbol** im Copilot Chat in den Kontext (manuelles Hinzufügen der Datei).
        3. Gib im Copilot Chat folgenden Prompt ein:
           ```
           Write an SQL query to fetch all tasks along with their project name, assigned user, and the number of comments.
           ```

   ### **Optional: Abfrage anpassen**
    - Gib im Chat folgenden Prompt ein:
      ```
      Modify the query to include only tasks that are not completed and sort them by project name and priority.
      ```
    - Übernehme die angepasste Abfrage und speichere sie ab.

## **3. GitHub Copilot CLI**

1. **CLI-Kommandos mit Copilot optimieren**
    - **Ziel:** Demonstriere, wie Copilot CLI komplexe Aufgaben in der Kommandozeile erleichtert.

   ### **Erster Versuch: Suche nach Java-Dateien**
    1. Wechsel in die **WSL2 Ubuntu Shell**.
    2. Weise kurz darauf hin, dass die GitHub Copilot CLI separat installiert werden muss, und verweise auf die
       Dokumentation von GitHub Copilot CLI (falls benötigt).
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
    6. Überprüfe die Ergebnisse und diskutiere die Nützlichkeit von Copilot CLI bei der Erstellung komplexer
       Shell-Kommandos.

   ### **Zweiter Versuch: Docker-Container anzeigen und verfeinern**
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

   ### Terminal chat
   canary channel nötig

   ### Powershell (prüfen wie context powershell zu setzen ):
   gh copilot suggest "List recursively directories and print only directories with file name starting with test"
   output oft bash, context setzen powershell
   gh copilot suggest "in powershell show all ports blocked by processes"

   ### **Erklärung:**
    - Zeige, wie Copilot CLI in verschiedenen Kontexten nützlich ist, von Dateisuche bis Docker-Management.
    - Diskutiere, wie die Verfeinerung über **Revise command** den Workflow iterativ verbessert.
    - Betone die Vorteile der automatisierten Generierung für wiederkehrende oder komplexe Aufgaben.
