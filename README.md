# 🎬 Sistema di Prenotazione Cinema

Applicazione Java da console per la gestione delle prenotazioni di posti in una sala cinematografica.

## Funzionalità

- **Visualizzare i posti disponibili** — Mappa della sala con posti liberi (`O`) e prenotati (`X`)
- **Prenotare un posto** — Seleziona riga e colonna per prenotare
- **Annullare una prenotazione** — Libera un posto già prenotato
- **Statistiche** — Visualizza posti prenotati totali e percentuale di occupazione

## Struttura del Progetto

```
cinema-booking-system/
├── src/
│   ├── main/
│   │   ├── Cinema.java        # Logica gestione posti
│   │   └── Main.java          # Menu e interazione utente
│   └── test/
│       └── CinemaTest.java    # Test JUnit5
├── lib/                        # JUnit5 JARs
├── .gitignore
└── README.md
```

## Tecnologie

- **Java 17+**
- **JUnit 5** per il testing (TDD)
- **Git/GitHub** per il versionamento

## Come Compilare e Eseguire

```bash
# Compilare
javac -d out src/main/*.java

# Eseguire
java -cp out Main
```

## Come Eseguire i Test

```bash
# Compilare i test
javac -cp "lib/*${SEP}src/main" -d out src/test/CinemaTest.java

# Eseguire i test
java -cp "out${SEP}lib/*" org.junit.platform.console.ConsoleLauncher --select-class CinemaTest
```

## Sviluppo

Questo progetto segue l'approccio **Test Driven Development (TDD)**:
1. Scrivere il test (RED)
2. Scrivere il codice minimo per passare il test (GREEN)
3. Rifattorizzare il codice (REFACTOR)

## Branching Strategy

- `main` — Branch principale protetto
- `develop` — Branch di sviluppo
- `feature/*` — Branch per nuove funzionalità
- Ogni feature viene mergiata tramite **Pull Request**

## Autore

Progetto sviluppato come esercitazione TPSI
