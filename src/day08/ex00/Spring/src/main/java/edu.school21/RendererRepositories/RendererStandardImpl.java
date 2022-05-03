package edu.school21.RendererRepositories;

import edu.school21.PreProcessorRepositories.PreProcessor;

public class RendererStandardImpl implements Renderer{

    private PreProcessor preProcessor;

    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void PreProcessor(String str) {
        System.out.println(preProcessor.PreProc(str));
    }
}
