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
        - Füge das Feld `dueDate` hinzu:
          ```java
          private LocalDate dueDate;
          ```
        - Beobachte, wie Copilot Vorschläge für zusätzliche Felder wie `priority` oder `createdAt` macht.
    - Nutze Kommentare, um weitere Felder hinzuzufügen:
      ```java
      // Add a priority field for tasks
      ```
        - Beispiel: `private int priority;`

    - **Vorschläge im Menü „GitHub Copilot“ überprüfen:**
        - Während du Code vervollständigst, kannst du rechts im IntelliJ-Menü unter „GitHub Copilot“ alle alternativen Vorschläge ansehen.
        - Probiere aus, wie du die Vorschläge durchblättern und auswählen kannst, falls der initial vorgeschlagene Code nicht passend ist.
        - **Hinweis:** Auch wenn diese Funktion nicht immer genutzt wird, ist sie hilfreich, um verschiedene Ansätze zu vergleichen.

2. **Chat verwenden:**
    - Verwende den Copilot Chat, um automatisch die Endpunkte für **Anlegen**, **Ändern** und **Löschen** von Tasks zu erstellen:
      ```java
      // Create endpoints for creating, updating, and deleting tasks
      ```
    - Frage: „Can you generate three REST endpoints for creating, updating, and deleting tasks in the TaskController?“
    - Überprüfe die generierten Methoden, die z. B. so aussehen könnten:
      ```java
      @PostMapping
      public Task createTask(@RequestBody Task task) {
          return taskRepository.save(task);
      }
 
      @PutMapping("/{id}")
      public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
          task.setId(id);
          return taskRepository.save(task);
      }
 
      @DeleteMapping("/{id}")
      public void deleteTask(@PathVariable Long id) {
          taskRepository.deleteById(id);
      }
      ```
    - Erkläre den Vorteil der generierten Methoden und passe sie bei Bedarf an.

3. **Benutzerdefinierter Endpunkt mittels Chat generieren:**
    - Nutze den Copilot Chat, um einen benutzerdefinierten Endpunkt hinzuzufügen, der nicht im Standard-Repository vorhanden ist. Beispiel: Einen Endpunkt, um alle Tasks mit einem bestimmten Status (`completed`) zu finden:
      ```java
      // Create an endpoint to find tasks by their completion status
      ```
    - Frage im Chat: „Can you generate a custom REST endpoint in the TaskController to find tasks by their completion status?“
    - Überprüfe die generierten Methoden, die z. B. so aussehen könnten:
      ```java
      @GetMapping("/status/{completed}")
      public List<Task> getTasksByStatus(@PathVariable boolean completed) {
          return taskRepository.findByCompleted(completed);
      }
      ```
    - **Ergänze das Repository entsprechend:**
        - Falls die Methode im Repository noch nicht existiert, lasse Copilot sie generieren:
          ```java
          // Add a method to find tasks by completion status
          List<Task> findByCompleted(boolean completed);
          ```
        - Füge diese Methode zur `TaskRepository`-Schnittstelle hinzu.

    - **Erklärung:**
        - Zeige, wie der Chat nicht nur Controller-Methoden, sondern auch benutzerdefinierte Queries in der Repository-Schicht ergänzt.
        - Betone, dass dies eine der Stärken von Copilot ist – das automatische Generieren von Code auf mehreren Ebenen.

4. **Chat verwenden: Allgemeine technische Fragen stellen**
    - Verwende den Copilot Chat, um allgemeine technische Fragen zu stellen, die sich am Beispielcode orientieren.
    - Beispiele:
        - Frage: „Wie funktioniert die Annotation `@Entity` in JPA?“
            - **Ziel:** Erklärung, wie `@Entity` eine Klasse für die JPA-Persistenzschicht markiert.
        - Frage: „Welche Vorteile hat `@Repository`?“
            - **Ziel:** Klärung der Rolle von Repositories in der Spring-Architektur.
        - Frage: „Was ist der Unterschied zwischen `@RestController` und `@Controller`?“
            - **Ziel:** Verständnis der Unterschiede in der Verwendung von REST-Endpunkten und klassischen MVC-Controllern.
    - **Erklärung:**
        - Betone, wie der Chat dabei hilft, schnell Kontextinformationen zu Annotationen oder Framework-Details bereitzustellen.
        - Zeige, wie die Antworten direkt zur besseren Dokumentation oder Weiterentwicklung des Codes beitragen können.

#### **1.3 GitHub Copilot: Advanced**

1. **Komplexere Methode generieren lassen**
    - Nutze Copilot, um eine komplexere Methode zu erstellen, z. B. eine, die Tasks nach Fälligkeit filtert und nach Priorität sortiert:
      ```java
      // Get all tasks that are due within the next 7 days, sorted by priority
      ```
    - Frage im Chat: „Can you create a method in the TaskController to fetch tasks due within the next 7 days, sorted by priority?“
    - Überprüfe die generierte Methode, die z. B. so aussehen könnte:
      ```java
      @GetMapping("/due-soon")
      public List<Task> getTasksDueSoon() {
          LocalDate today = LocalDate.now();
          LocalDate nextWeek = today.plusDays(7);
          return taskRepository.findAll().stream()
              .filter(task -> task.getDueDate() != null && 
                              !task.getDueDate().isBefore(today) && 
                              !task.getDueDate().isAfter(nextWeek))
              .sorted(Comparator.comparingInt(Task::getPriority))
              .toList();
      }
      ```

    - **Erklärung:**
        - Zeige, wie Copilot kontextbezogene Logik generiert, einschließlich Datumshandling und Stream-APIs.

2. **Unit-Test für die komplexe Methode generieren**
   - Verwende den Copilot Chat, um mit dem Command `/tests` automatisch einen Unit-Test für die Methode `getTasksDueSoon()` generieren zu lassen:
     ```java
     // Generate a unit test for the getTasksDueSoon() method
     ```
   - Eingabe im Chat:
     ```
     /tests Generate a unit test for the getTasksDueSoon() method in TaskController
     ```
    - Lasse Copilot die Testmethode erstellen, z. B.:
      ```java
      @Test
      public void testGetTasksDueSoon() {
          // Arrange
          Task task1 = new Task();
          task1.setDueDate(LocalDate.now().plusDays(3));
          task1.setPriority(1);
 
          Task task2 = new Task();
          task2.setDueDate(LocalDate.now().plusDays(10)); // outside range
          task2.setPriority(2);
 
          Task task3 = new Task();
          task3.setDueDate(LocalDate.now().plusDays(5));
          task3.setPriority(3);
 
          List<Task> tasks = List.of(task1, task2, task3);
          when(taskRepository.findAll()).thenReturn(tasks);
 
          // Act
          List<Task> result = taskController.getTasksDueSoon();
 
          // Assert
          assertEquals(2, result.size());
          assertEquals(1, result.get(0).getPriority());
          assertEquals(3, result.get(1).getPriority());
      }
      ```

    - **Erklärung:**
        - Zeige, wie Copilot Testdaten generiert, den Testfall strukturiert und Assertions hinzufügt.
        - Betone die Zeitersparnis bei der Testgenerierung und die Notwendigkeit von Testanpassungen bei komplexen Szenarien.

3. **Javadoc für die Klasse und Methode generieren**
    - Demonstriere, wie Javadoc mit GitHub Copilot für einzelne Methoden und die gesamte Klasse erstellt werden kann.

   #### **Methode 1: Durch Lostippen von `/**` vor der Methode**
    - Setze den Cursor vor die Methode `getTasksDueSoon()` und tippe `/**`.
    - Copilot generiert automatisch eine passende Javadoc basierend auf der Methodensignatur.

   #### **Methode 2: Mit dem Command `/doc` im Chat**
    - Markiere die gesamte Klasse `TaskController` und öffne den Copilot Chat.
    - Verwende den Command:
      ```
      /docs
      ```
    - Copilot erstellt eine umfassende Javadoc-Dokumentation für die Klasse sowie alle enthaltenen Methoden.

   **Hinweis:** Erkläre die Vorteile der Chat-gestützten Generierung für größere Klassen und zeige, wie die Dokumentation für bessere Lesbarkeit und Konsistenz angepasst werden kann.

4. **Code analysieren und vereinfachen**
   - Zeige, wie GitHub Copilot komplexen Code erklären und optimieren kann, indem die Methode `getTasksDueSoonComplicated()` im `TaskService` verwendet wird.

   #### **1. Code erklären mit dem Command `/explain`**
   - Markiere die Methode `getTasksDueSoonComplicated()` und öffne den Copilot Chat.
   - Verwende den Command:
     ```
     /explain
     ```
   - Beobachte die Antwort von Copilot, die z. B. eine Schritt-für-Schritt-Erklärung der Methode und ihrer Logik liefert:
      - Filterung von Aufgaben basierend auf dem Fälligkeitsdatum.
      - Sortierung von Aufgaben nach Priorität.
      - Verwendung von Schleifen und Comparatoren.

   **Erklärung:**
   - Betone, wie Copilot helfen kann, komplexe Code-Stellen besser zu verstehen, insbesondere bei fremdem oder älterem Code.

   #### **2. Code vereinfachen mit Inline-Chat und `/simplify`**
   - Selektiere die Methode `getTasksDueSoonComplicated()` im Editor.
   - Öffne den Inline-Chat mit `Alt + Enter` (oder die entsprechende Shortcut-Kombination deiner IDE).
   - Verwende den Command:
     ```
     /simplify Using Stream API
     ```
   - Gehe im Vorschlag von Copilot auf **Preview**, um den vereinfachten Code anzusehen.
   - Übernehme den Vorschlag durch **Accept**, falls die Änderungen korrekt sind.

   **Erklärung:**
   - Zeige, wie Copilot mithilfe von Streams und Lambdas redundante Schleifen ersetzt und den Code klarer strukturiert.
   - Betone, dass der Inline-Chat besonders praktisch für punktuelles Refactoring ist und direkt im Editor verwendet werden kann.

   **Extra-Tipp:**
   - Zeige den direkten Vergleich zwischen der ursprünglichen und der vereinfachten Version, um die Vorteile von Copilot deutlich zu machen.

5. **Fehlschlagenden Unit-Test reparieren**
- Zeige, wie GitHub Copilot mithilfe des `/fix` Commands fehlschlagende Unit-Tests analysieren und korrigieren kann.

#### **Schritte:**
1. **Test manipulieren:**
    - Ändere den Code in einem Unit-Test so, dass der Test fehlschlägt, z. B. durch Verfälschen eines Werts oder Ändern der erwarteten Ausgabe.
    - Führe den Test aus, um den Fehler auszulösen, und kopiere den Stacktrace des Fehlers.

2. **Fehler analysieren:**
    - Öffne den Copilot Chat und verwende den Command:
      ```
      /fix Fix the failing unit test
      ```
    - Füge den Stacktrace in den Chat ein, um Copilot mehr Kontext zu geben.

3. **Vorschlag übernehmen:**
    - Überprüfe den Lösungsvorschlag von Copilot und übertrage die Korrektur in den Code.

4. **Test erneut ausführen:**
    - Starte den Test erneut, um zu zeigen, dass der Fehler behoben wurde und der Test jetzt grün ist.

**Erklärung:**
- Zeige, wie Copilot den Fehler auf Basis des Stacktraces analysiert und eine Lösung vorschlägt.
- Betone die Zeitersparnis und den Nutzen bei der Fehlersuche, insbesondere bei komplexen Fehlern.

### **2. Wechsel zu VSCode**

----------------------
MARKER
----------------------


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
