#cmake_minimum_required(VERSION 3.4.1)

cmake_minimum_required(VERSION 3.4.1)

PROJECT(hello)

add_library(hello
            SHARED
            src/main/cpp/hello.cpp)

