package com.asstrans.agremiados;

import com.asstrans.agremiados.utils.DataUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Main {

    public static void main(String[] args) {
        System.out.println(DataUtils.getMesAtual());
        DataUtils.getUltimoDiaDoMes(0);

        System.out.println(new BigDecimal(200).divide(new BigDecimal(6), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP));
    }
}
