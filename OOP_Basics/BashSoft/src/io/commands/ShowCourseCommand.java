package io.commands;

import exeptions.InvalidInputException;
import io.IOManager;
import judge.Tester;
import network.DownloadManager;
import repository.StudentsRepository;

public class ShowCourseCommand extends Command{

    public ShowCourseCommand(String input,
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
        if (data.length != 2 && data.length != 3) {
            throw new InvalidInputException(this.getInput());
        }

        if (data.length == 2) {
            String courseName = data[1];
            this.getRepository().getStudentsByCourse(courseName);
            return;
        }

        String courseName = data[1];
        String userName = data[2];
        this.getRepository().getStudentMarkInCourse(courseName, userName);

    }
}
