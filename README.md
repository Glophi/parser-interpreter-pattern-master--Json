
#  Wähle bei Tags "Gerüst" aus wenn du das fertige Projekt selber machen willst

# 🧩 JSON Parser & Interpreter – Recursive Descent Parser (Matura-Projekt)

## 🎯 Zielsetzung

In diesem Projekt soll ein einfacher **Parser und Interpreter für JSON-Daten** in Java entwickelt werden.  
Ziel ist es, einen **rekursiven AbstiegsParser** (Recursive Descent Parser) zu implementieren, der einfache JSON-Objekte analysiert und sie mithilfe des **Interpreter-Patterns** in eine Java-Objektstruktur (z. B. `Map<String, Object>`) überführt.

Die Eingabe erfolgt als String in JSON-Syntax, das Ergebnis ist eine verschachtelte Java-Datenstruktur, mit der man programmgesteuert weiterarbeiten kann.

## Grammatik 

TODO
````code 

<JSON> ::= <Object>
<Object> ::= '{' <pairList> '}'
<pairList> ::= <pair> | <pair> ',' <pairList>
<pair> ::= string ':' value
<value> ::= string | number | object



````
---


## 📋 Aufgabenstellung

Analysieren und interpretieren Sie Texte wie diesen und geben Sie ihn in der GUI aus:
Im
```json
{
  "name": "John",
  "age": 42,
  "address": {
    "city": "Vienna"
  }
}
