package org.habv.automation.configurations.testng;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class StatisticsListener implements ITestListener {

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final List<ITestResult> testSuccess = new ArrayList<>();
    private final List<ITestResult> testFailure = new ArrayList<>();
    private final List<ITestResult> testSkipped = new ArrayList<>();
    private LocalDateTime startDate;
    private LocalDateTime finishDate;

    @Override
    public void onTestStart(ITestResult itr) {
    }

    @Override
    public void onTestSuccess(ITestResult itr) {
        testSuccess.add(itr);
    }

    @Override
    public void onTestFailure(ITestResult itr) {
        testFailure.add(itr);
    }

    @Override
    public void onTestSkipped(ITestResult itr) {
        testSkipped.add(itr);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult itr) {
    }

    @Override
    public void onStart(ITestContext itc) {
        startDate = LocalDateTime.now();
    }

    @Override
    public void onFinish(ITestContext itc) {
        finishDate = LocalDateTime.now();
        printStatistics();
    }

    private void printStatistics() {
        System.out.println("=================================================");
        System.out.println("# ESTADISTICAS");
        System.out.println();
        System.out.println("## Test Exitosos");
        System.out.println();
        testSuccess.forEach(this::printTestResult);
        System.out.println("## Test Fallidos");
        System.out.println();
        testFailure.forEach(this::printTestResult);
        System.out.println("## Test Omitidos");
        System.out.println();
        testSkipped.forEach(this::printTestResult);
        System.out.println("## Resumen");
        System.out.println();
        System.out.println(" * Test Exitosos:\t" + testSuccess.size());
        System.out.println(" * Test Fallidos:\t" + testFailure.size());
        System.out.println(" * Test Omitidos:\t" + testSkipped.size());
        System.out.println(" * Inicio Ejecución:\t" + startDate.format(dtf));
        System.out.println(" * Fin Ejecución:\t" + finishDate.format(dtf));
        System.out.println(" * Duración:\t\t" + Duration.between(startDate, finishDate).getSeconds() + " segundos");
        System.out.println("=================================================");
    }

    private void printTestResult(ITestResult itr) {
        System.out.println(" - Test Suite:\t\t" + itr.getInstanceName());
        System.out.println(" - Test Metodo:\t\t" + itr.getName());
        LocalDateTime start = LocalDateTime.ofInstant(Instant.ofEpochMilli(itr.getStartMillis()), ZoneId.systemDefault());
        LocalDateTime end = LocalDateTime.ofInstant(Instant.ofEpochMilli(itr.getEndMillis()), ZoneId.systemDefault());
        System.out.println(" - Parametros:\t\t" + Stream.of(itr.getParameters()).map(Object::toString).collect(Collectors.joining(", ")));
        System.out.println(" - Inicio Ejecución:\t" + start.format(dtf));
        System.out.println(" - Fin Ejecución:\t" + end.format(dtf));
        System.out.println(" - Duración:\t\t" + Duration.between(start, end).getSeconds() + " segundos");
        System.out.println();
    }

}
