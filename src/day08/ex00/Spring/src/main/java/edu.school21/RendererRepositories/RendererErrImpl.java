package edu.school21.RendererRepositories;

import edu.school21.PreProcessorRepositories.PreProcessor;

public class RendererErrImpl implements Renderer{

    private PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void PreProcessor(String str) {
        System.err.println(preProcessor.PreProc(str));
    }
}
