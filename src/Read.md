# 🧩 JSON Parser & Interpreter – Recursive Descent Parser (Matura-Projekt)

## 🎯 Zielsetzung

In diesem Projekt soll ein einfacher **Parser und Interpreter für JSON-Daten** in Java entwickelt werden.  
Ziel ist es, einen **rekursiven AbstiegspParser** (Recursive Descent Parser) zu implementieren, der einfache JSON-Objekte analysiert und sie mithilfe des **Interpreter-Patterns** in eine Java-Objektstruktur (z. B. `Map<String, Object>`) überführt.

Die Eingabe erfolgt als String in JSON-Syntax, das Ergebnis ist eine verschachtelte Java-Datenstruktur, mit der man programmgesteuert weiterarbeiten kann.

---


## 📋 Aufgabenstellung

Analysieren und interpretieren Sie Texte wie diesen:

```json
{
  "name": "John",
  "age": 42,
  "address": {
    "city": "Vienna"
  }
}
