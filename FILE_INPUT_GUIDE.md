# File Input Feature - Usage Guide

## Overview
The Data Structures and Algorithms GUI now supports loading numbers from text files instead of manually typing them. This feature is available in both Sorting and Searching panels.

## How to Use File Input

### 1. Prepare Your Data File
Create a text file (.txt) with comma-separated numbers. Examples:

**Simple file (sample_numbers.txt):**
```
64,34,25,12,22,11,90,5,77,30
```

**Multi-line file (large_numbers.txt):**
```
89,45,23,67,12,78,34,56,91,28,15,73,42,66,19
33,87,54,29,76,18,95,41,62,37,84,26,59,13,71
48,82,35,69,21,74,46,83,27,58,14,79,32,65,20
```

### 2. Using File Input in Sorting Panel
1. Click "🔢 Sorting Algorithms" from main menu
2. Click the "📁 Load from File" button
3. Select your text file with numbers
4. Numbers will automatically appear in the input field
5. Choose your sorting algorithm and click "Sort Array"

### 3. Using File Input in Searching Panel
1. Click "🔍 Searching Algorithms" from main menu
2. Click the "📁 Load from File" button
3. Select your text file with numbers
4. Numbers will automatically appear in the array input field
5. Enter your target value manually
6. Choose your searching algorithm and click "Search"

## File Format Requirements
- Files must be plain text (.txt format)
- Numbers should be separated by commas
- Spaces around commas are automatically handled
- Multi-line files are supported (each line can contain comma-separated numbers)
- Only integer numbers are supported

## Sample Files
Two sample files are included in the project directory:
- `sample_numbers.txt` - Small dataset for quick testing
- `large_numbers.txt` - Larger dataset for performance testing

## Error Handling
The system will display helpful error messages if:
- File cannot be read
- File doesn't exist
- File contains invalid data
- Permission issues occur

## Benefits
- ✅ Load large datasets quickly
- ✅ Reuse the same data for multiple tests
- ✅ Test with consistent datasets
- ✅ No typing errors from manual input
- ✅ Support for very large arrays

## Running the Application
```cmd
javac -cp src gui\*.java
java -cp "src;gui" DataStructuresAndAlgorithms.gui.MainGUI
```
