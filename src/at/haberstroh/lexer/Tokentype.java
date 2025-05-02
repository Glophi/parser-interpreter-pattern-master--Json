/*
 * Tokentype.java
 * 2019-12-05 Harald. R. Haberstroh
 */
package at.haberstroh.lexer;

/**
 *
 * @author Harald R. Haberstroh <hp@htlwrn.ac.at>
 */

public enum Tokentype {
  LEFT_BRACE,    // {
  RIGHT_BRACE,   // }
  COLON,         // :
  COMMA,         // ,
  STRING,        // "text"
  NUMBER,        // 123 or 3.14
  EOF
}
