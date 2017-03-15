package io.commands;

import exeptions.InvalidInputException;
import io.IOManager;
import io.OutputWriter;
import judge.Tester;
import network.DownloadManager;
import repository.StudentsRepository;

public class DropDatabaseCommand extends Command {

    public DropDatabaseCommand(String input,
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
        if (data.length != 1) {
            throw new InvalidInputException(this.getInput());
        }

        this.getRepository().unloadData();
        OutputWriter.writeMessageOnNewLine("Database dropped!");
    }
}
