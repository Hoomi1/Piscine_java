package edu.school21.PrinterRepositories;

import edu.school21.RendererRepositories.Renderer;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer{

    private Renderer render;

    public PrinterWithDateTimeImpl(Renderer render) {
        this.render = render;
    }

    @Override
    public void print(String str) {
        render.PreProcessor(str + " " + LocalDateTime.now());
    }
}
