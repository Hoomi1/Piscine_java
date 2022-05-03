package edu.school21.PrinterRepositories;

import edu.school21.RendererRepositories.Renderer;

public class PrinterWithPrefixImpl implements Printer{

    private Renderer render;
    private String prefix;

    public PrinterWithPrefixImpl(Renderer render) {
        this.render = render;
    }

    @Override
    public void print(String str) {
        render.PreProcessor(prefix + str);
    }

    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }
}
