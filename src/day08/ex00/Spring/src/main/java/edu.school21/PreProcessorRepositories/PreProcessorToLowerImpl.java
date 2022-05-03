package edu.school21.PreProcessorRepositories;

public class PreProcessorToLowerImpl implements PreProcessor{
    @Override
    public String PreProc(String str) {
        return str.toLowerCase();
    }
}
