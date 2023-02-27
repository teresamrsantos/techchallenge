package com.challenge.challenge.utils;

public class RemoveAccents {

    public static final String TRANSLATE = "translate({0}, {1}, {2})";
    public static final String TRANSLATE_FUNCTION = "TRANSLATE";
    public static final String DIACRITICAL_MARKS = "\\p{InCombiningDiacriticalMarks}+";
    public static final String LETRAS_ACENTOS = "áàâãäéèêëíìïóòôõöúùûüÁÀÂÃÄÉÈÊËÍÌÏÓÒÔÕÖÚÙÛÜçÇ";
    public static final String LETRAS_SEM_ACENTOS = "aaaaaeeeeiiiooooouuuuAAAAAEEEEIIIOOOOOUUUUcC";

    RemoveAccents() {
    }
}