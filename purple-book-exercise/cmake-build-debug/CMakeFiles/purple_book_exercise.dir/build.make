# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.9

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /Applications/CLion.app/Contents/bin/cmake/bin/cmake

# The command to remove a file.
RM = /Applications/CLion.app/Contents/bin/cmake/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = "/Users/hiki/OneDrive - smail.nju.edu.cn/Projects/algorithm-diary/purple-book-exercise"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "/Users/hiki/OneDrive - smail.nju.edu.cn/Projects/algorithm-diary/purple-book-exercise/cmake-build-debug"

# Include any dependencies generated for this target.
include CMakeFiles/purple_book_exercise.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/purple_book_exercise.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/purple_book_exercise.dir/flags.make

CMakeFiles/purple_book_exercise.dir/main.cpp.o: CMakeFiles/purple_book_exercise.dir/flags.make
CMakeFiles/purple_book_exercise.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="/Users/hiki/OneDrive - smail.nju.edu.cn/Projects/algorithm-diary/purple-book-exercise/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/purple_book_exercise.dir/main.cpp.o"
	/Library/Developer/CommandLineTools/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/purple_book_exercise.dir/main.cpp.o -c "/Users/hiki/OneDrive - smail.nju.edu.cn/Projects/algorithm-diary/purple-book-exercise/main.cpp"

CMakeFiles/purple_book_exercise.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/purple_book_exercise.dir/main.cpp.i"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "/Users/hiki/OneDrive - smail.nju.edu.cn/Projects/algorithm-diary/purple-book-exercise/main.cpp" > CMakeFiles/purple_book_exercise.dir/main.cpp.i

CMakeFiles/purple_book_exercise.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/purple_book_exercise.dir/main.cpp.s"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S "/Users/hiki/OneDrive - smail.nju.edu.cn/Projects/algorithm-diary/purple-book-exercise/main.cpp" -o CMakeFiles/purple_book_exercise.dir/main.cpp.s

CMakeFiles/purple_book_exercise.dir/main.cpp.o.requires:

.PHONY : CMakeFiles/purple_book_exercise.dir/main.cpp.o.requires

CMakeFiles/purple_book_exercise.dir/main.cpp.o.provides: CMakeFiles/purple_book_exercise.dir/main.cpp.o.requires
	$(MAKE) -f CMakeFiles/purple_book_exercise.dir/build.make CMakeFiles/purple_book_exercise.dir/main.cpp.o.provides.build
.PHONY : CMakeFiles/purple_book_exercise.dir/main.cpp.o.provides

CMakeFiles/purple_book_exercise.dir/main.cpp.o.provides.build: CMakeFiles/purple_book_exercise.dir/main.cpp.o


# Object files for target purple_book_exercise
purple_book_exercise_OBJECTS = \
"CMakeFiles/purple_book_exercise.dir/main.cpp.o"

# External object files for target purple_book_exercise
purple_book_exercise_EXTERNAL_OBJECTS =

purple_book_exercise: CMakeFiles/purple_book_exercise.dir/main.cpp.o
purple_book_exercise: CMakeFiles/purple_book_exercise.dir/build.make
purple_book_exercise: CMakeFiles/purple_book_exercise.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="/Users/hiki/OneDrive - smail.nju.edu.cn/Projects/algorithm-diary/purple-book-exercise/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable purple_book_exercise"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/purple_book_exercise.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/purple_book_exercise.dir/build: purple_book_exercise

.PHONY : CMakeFiles/purple_book_exercise.dir/build

CMakeFiles/purple_book_exercise.dir/requires: CMakeFiles/purple_book_exercise.dir/main.cpp.o.requires

.PHONY : CMakeFiles/purple_book_exercise.dir/requires

CMakeFiles/purple_book_exercise.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/purple_book_exercise.dir/cmake_clean.cmake
.PHONY : CMakeFiles/purple_book_exercise.dir/clean

CMakeFiles/purple_book_exercise.dir/depend:
	cd "/Users/hiki/OneDrive - smail.nju.edu.cn/Projects/algorithm-diary/purple-book-exercise/cmake-build-debug" && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" "/Users/hiki/OneDrive - smail.nju.edu.cn/Projects/algorithm-diary/purple-book-exercise" "/Users/hiki/OneDrive - smail.nju.edu.cn/Projects/algorithm-diary/purple-book-exercise" "/Users/hiki/OneDrive - smail.nju.edu.cn/Projects/algorithm-diary/purple-book-exercise/cmake-build-debug" "/Users/hiki/OneDrive - smail.nju.edu.cn/Projects/algorithm-diary/purple-book-exercise/cmake-build-debug" "/Users/hiki/OneDrive - smail.nju.edu.cn/Projects/algorithm-diary/purple-book-exercise/cmake-build-debug/CMakeFiles/purple_book_exercise.dir/DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/purple_book_exercise.dir/depend
