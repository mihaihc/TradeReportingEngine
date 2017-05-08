package com.trade.main;

import com.trade.model.Instruction;
import com.trade.reports.DailyTradeReport;
import com.trade.sample.GenerateSample;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GenerateSample sample = new GenerateSample();
        ArrayList<Instruction> instructionList = sample.generateSampleData();
        DailyTradeReport.amountUSDSettledSincoming(instructionList);
        DailyTradeReport.amountUSDSettledSoutgoing(instructionList);
        DailyTradeReport.incomingRank(instructionList);
        DailyTradeReport.outgoingRank(instructionList);
    }
}
