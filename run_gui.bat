@echo off
echo Compiling GUI application...
javac -cp src gui\*.java

if %ERRORLEVEL% EQU 0 (
    echo Compilation successful!
    echo Starting GUI application...
    java -cp "src;gui" DataStructuresAndAlgorithms.gui.MainGUI
) else (
    echo Compilation failed!
    pause
)
