package com.number.translate.service;

import org.springframework.stereotype.Service;

@Service
public class TranslateNumberService {

    private static final String[] unidades = {
            "",
            " um",
            " dois",
            " três",
            " quatro",
            " cinco",
            " seis",
            " sete",
            " oito",
            " nove",
            " dez",
            " onze",
            " doze",
            " treze",
            " quatorze",
            " quinze",
            " dezesseis",
            " dezessete",
            " dezoito",
            " dezenove"
    };

    private static final String[] dezenas = {
            "",
            " dez",
            " vinte",
            " trinta",
            " quarenta",
            " cinquenta",
            " sessenta ",
            " setenta",
            " oitenta",
            " noventa"
    };

    private static final String[] centenas = {
            "",
            " cento",
            " duzentos",
            " trezentos",
            " quatrocentos",
            " quinhentos",
            " seiscentos ",
            " setecentos",
            " oitocentos",
            " novecentos"
    };


    public String translate(int number) {
        boolean negative = false;

        if (number < 0) {
            negative = true;
        }
        if (number > 999 || number < -999) {
            String value = String.valueOf(number);
            String value2 = String.valueOf(number);
            int length = value.length();

            if (!negative) {
                if (length == 4) {
                    value = value.substring(0, 1);
                    value2 = value2.substring(1, 4);
                } else if (length == 5) {
                    value = value.substring(0, 2);
                    value2 = value2.substring(2, 5);
                }
            } else {
                if (length == 5) {
                    value = value.substring(1, 2);
                    value2 = value2.substring(2, 5);
                } else if (length == 6) {
                    value = value.substring(1, 3);
                    value2 = value2.substring(2, 5);
                }
            }


            int halfLeft = Integer.parseInt(value);
            int halfRight = Integer.parseInt(value2);


            String s1 = converteInteiroParaTexto(halfLeft);
            String s2;
            if (halfRight > 0) {
                s2 = converteInteiroParaTexto(halfRight);
            } else {
                if (negative) {
                    return "menos mil";
                }
                return "mil";
            }

            if (negative) {
                return "menos" + s1 + " mil e " + s2;
            }
            return s1 + " mil e " + s2;

        } else {
            if (negative) {
                number *= -1;
                String textual = converteInteiroParaTexto(number);

                return "menos " + textual;
            } else {
                return converteInteiroParaTexto(number);
            }

        }
    }

    private static String converteInteiroParaTexto(int number) {
        String soFar;

        if (number == 0) {
            return "zero";
        } else if (number == 100) {
            return "cem";
        }
        if (number % 100 < 20) {
            soFar = unidades[number % 100];
            number /= 100;
        } else {
            soFar = unidades[number % 10];
            number /= 10;

            if (!soFar.equals("")) {
                soFar = dezenas[number % 10] + " e " + soFar;
            } else {
                soFar = dezenas[number % 10] + soFar;
            }

            number /= 10;
        }
        if (number == 0) {
            return soFar;
        } else if (soFar.equals("")) {
            return centenas[number];
        }
        return centenas[number] + " e" + soFar;
    }
}
