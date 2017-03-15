package io.commands;

import exeptions.InvalidInputException;
import io.IOManager;
import judge.Tester;
import network.DownloadManager;
import repository.StudentsRepository;
import staticData.SessionData;

import java.awt.*;
import java.io.File;

public class OpenFileCommand extends Command {

    public OpenFileCommand(String input,
                           String[] data,
                           Tester tester,
                           StudentsRepository repository,
                           DownloadManager downloadManager,
                           IOManager ioManager) {
        super(input, data, tester, repository, downloadManager, ioManager);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2) {
            throw new InvalidInputException(this.getInput());
        }

        String fileName = data[1];
        String filePath = SessionData.currentPath + "\\" + fileName;
        File file = new File(filePath);
        Desktop.getDesktop().open(file);
    }
}
