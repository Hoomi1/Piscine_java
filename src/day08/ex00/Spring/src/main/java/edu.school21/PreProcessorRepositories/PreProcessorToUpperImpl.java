package edu.school21.PreProcessorRepositories;

public class PreProcessorToUpperImpl implements PreProcessor{
    @Override
    public String PreProc(String str) {
        return str.toUpperCase();
    }
}
