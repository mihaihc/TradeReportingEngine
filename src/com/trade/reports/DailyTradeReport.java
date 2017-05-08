package com.trade.reports;

import com.trade.model.Instruction;

import java.util.*;

public class DailyTradeReport {

    public static void amountUSDSettledSincoming(ArrayList<Instruction> instructionList) {
        Map<Date, Double> amountUSD = new TreeMap<Date, Double>();
        for (int i = 0; i < instructionList.size(); i++) {
            Instruction instruction = instructionList.get(i);
            if (instruction.getOperationFlag().compareToIgnoreCase("S") == 0) {
                double USDAmount = instruction.getPricePerUnit() * instruction.getUnits() * instruction.getAgreedFx();
                if (null == amountUSD.get(instruction.getSettlementDate())) {
                    amountUSD.put(instruction.getSettlementDate(), USDAmount);
                } else {
                    amountUSD.put(instruction.getSettlementDate(), amountUSD.get(instruction.getSettlementDate()) + USDAmount);
                }

            }
        }
        System.out.println("Amount in USD settled incoming everyday \n" + amountUSD.toString());
        System.out.println("---------------------------");
    }

    public static void amountUSDSettledSoutgoing(ArrayList<Instruction> instructionList) {
        Map<Date, Double> amountUSD = new TreeMap<Date, Double>();
        for (int i = 0; i < instructionList.size(); i++) {
            Instruction instruction = instructionList.get(i);
            if (instruction.getOperationFlag().compareToIgnoreCase("B") == 0) {
                double USDAmount = instruction.getPricePerUnit() * instruction.getUnits() * instruction.getAgreedFx();
                if (null == amountUSD.get(instruction.getSettlementDate())) {
                    amountUSD.put(instruction.getSettlementDate(), USDAmount);
                } else {
                    amountUSD.put(instruction.getSettlementDate(), amountUSD.get(instruction.getSettlementDate()) + USDAmount);
                }
            }
        }
        System.out.println("Amount in USD settled outgoing everyday \n" + amountUSD.toString());
        System.out.println("---------------------------");
    }

    public static void incomingRank(ArrayList<Instruction> instructionList) {
        Map<String, Double> incomingRanks = new TreeMap<String, Double>();

        for (int i = 0; i < instructionList.size(); i++) {
            Instruction instruction = instructionList.get(i);
            if (instruction.getOperationFlag().compareToIgnoreCase("S") == 0) {
                double USDAmount = instruction.getPricePerUnit() * instruction.getUnits() * instruction.getAgreedFx();
                if (null == incomingRanks.get(instruction.getEntityName())) {
                    incomingRanks.put(instruction.getEntityName(), USDAmount);
                } else {
                    incomingRanks.put(instruction.getEntityName(), incomingRanks.get(instruction.getEntityName()) + USDAmount);
                }
            }
        }

        incomingRanks = sortByValues(incomingRanks);
        int rank = 0;
        System.out.println("Ranking of entities based on incoming amount.");
        for (String key : incomingRanks.keySet()) {
            rank++;
            System.out.println(key + " has incoming rank : " + rank);
        }
        System.out.println("---------------------------");
    }

    public static void outgoingRank(ArrayList<Instruction> instructionList) {
        Map<String, Double> outgoingRanks = new TreeMap<String, Double>();

        for (int i = 0; i < instructionList.size(); i++) {
            Instruction instruction = instructionList.get(i);
            if (instruction.getOperationFlag().compareToIgnoreCase("B") == 0) {
                double USDAmount = instruction.getPricePerUnit() * instruction.getUnits() * instruction.getAgreedFx();
                if (null == outgoingRanks.get(instruction.getEntityName())) {
                    outgoingRanks.put(instruction.getEntityName(), USDAmount);
                } else {
                    outgoingRanks.put(instruction.getEntityName(), outgoingRanks.get(instruction.getEntityName()) + USDAmount);
                }
            }
        }

        outgoingRanks = sortByValues(outgoingRanks);
        int rank = 0;
        System.out.println("Ranking of entities based on outgoing amount.");
        for (String key : outgoingRanks.keySet()) {
            rank++;
            System.out.println(key + " has outgoing rank : " + rank);
        }
        System.out.println("---------------------------");
    }

    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator = new Comparator<K>() {
            public int compare(K k1, K k2) {
                int compare = map.get(k2).compareTo(map.get(k1));
                if (compare == 0) return 1;
                else return compare;
            }
        };
        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }
}
