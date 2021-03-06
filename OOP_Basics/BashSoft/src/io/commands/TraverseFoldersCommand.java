package io.commands;

import exeptions.InvalidInputException;
import io.IOManager;
import judge.Tester;
import network.DownloadManager;
import repository.StudentsRepository;

public class TraverseFoldersCommand extends Command{

    public TraverseFoldersCommand(String input,
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
        if (data.length != 1 && data.length != 2) {
            throw new InvalidInputException(this.getInput());
        }

        if (data.length == 1) {
            this.getIoManager().traverseDirectory(0);
            return;
        }

        this.getIoManager().traverseDirectory(Integer.valueOf(data[1]));
    }
}
