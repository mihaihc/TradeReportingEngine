package com.trade.sample;

import com.trade.model.Instruction;

import java.util.ArrayList;

public class GenerateSample {
    public ArrayList<Instruction> generateSampleData() {
        ArrayList<Instruction> instructionList = new ArrayList<Instruction>();
        Instruction instruction = new Instruction();
        instruction.setEntityName("foo");
        instruction.setOperationFlag("B");
        instruction.setAgreedFx(0.50);
        instruction.setCurrency("SGP");
        instruction.setInstructionDate("01 Jan 2016");
        instruction.setSettlementDate("02 Jan 2016");
        instruction.setUnits(200);
        instruction.setPricePerUnit(100.25);
        instructionList.add(instruction);

        instruction = new Instruction();
        instruction.setEntityName("foo1");
        instruction.setOperationFlag("B");
        instruction.setAgreedFx(0.50);
        instruction.setCurrency("SGP");
        instruction.setInstructionDate("02 Jan 2016");
        instruction.setSettlementDate("03 Jan 2016");
        instruction.setUnits(200);
        instruction.setPricePerUnit(100.25);
        instructionList.add(instruction);

        instruction = new Instruction();
        instruction.setEntityName("bar");
        instruction.setOperationFlag("S");
        instruction.setAgreedFx(0.22);
        instruction.setCurrency("AED");
        instruction.setInstructionDate("05 Jan 2016");
        instruction.setSettlementDate("07 Jan 2016");
        instruction.setUnits(70);
        instruction.setPricePerUnit(150.5);
        instructionList.add(instruction);

        instruction = new Instruction();
        instruction.setEntityName("bar1");
        instruction.setOperationFlag("S");
        instruction.setAgreedFx(0.22);
        instruction.setCurrency("AED");
        instruction.setInstructionDate("07 Jan 2016");
        instruction.setSettlementDate("09 Jan 2016");
        instruction.setUnits(450);
        instruction.setPricePerUnit(150.5);
        instructionList.add(instruction);

        instruction = new Instruction();
        instruction.setEntityName("bar2");
        instruction.setOperationFlag("S");
        instruction.setAgreedFx(0.22);
        instruction.setCurrency("AED");
        instruction.setInstructionDate("02 Jan 2016");
        instruction.setSettlementDate("03 Jan 2016");
        instruction.setUnits(3);
        instruction.setPricePerUnit(150.5);
        instructionList.add(instruction);
        return instructionList;
    }
}
