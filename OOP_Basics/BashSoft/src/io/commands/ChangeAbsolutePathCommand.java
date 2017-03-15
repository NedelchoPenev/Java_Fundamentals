package io.commands;

import exeptions.InvalidInputException;
import io.IOManager;
import judge.Tester;
import network.DownloadManager;
import repository.StudentsRepository;

public class ChangeAbsolutePathCommand extends Command {

    public ChangeAbsolutePathCommand(String input,
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

        String absolutePath = data[1];
        this.getIoManager().changeCurrentDirAbsolute(absolutePath);
    }
}
