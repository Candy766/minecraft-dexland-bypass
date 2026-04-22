@echo off
setlocal enabledelayedexpansion
set APP_HOME=%~dp0
java -jar "%APP_HOME%gradle\wrapper\gradle-wrapper.jar" %*
