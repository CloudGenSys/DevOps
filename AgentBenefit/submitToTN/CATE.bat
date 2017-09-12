@echo off

rem =================================================================
rem CATE Batch processor - for handling Continuous Integrated Testing

rem Author :  Kristopher R. Kycia
rem Date   :  26 February 2015

rem Version:  1.01a
rem =================================================================

set JMETERDIR=C:\apache-jmeter-2.12

set HOSTNAME=%1
set PORT=%2
set JMXSOURCE=%3

if .%1 == . goto usage
if .%2 == . goto usage
if .%3 == . goto usage

rem C:\apache-jmeter-2.12\bin\jmeter -Jhostname=localhost -Jport=5555 -n -t CGDemo-SubmitToTN-submitToTN.jmx
	
%JMETERDIR%\bin\jmeter.bat -Jhostname=%HOSTNAME% -Jport=%PORT% -n -t %JMXSOURCE%

goto end

:usage
echo Usage: CATE.bat hostname port jmxsource

:end
