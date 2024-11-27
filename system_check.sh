#!/bin/bash

# Check CPU and memory usage
echo "CPU and memory usage:"
top -b -n1 | head -n 10

# Identify processes consuming the most resources
echo -e "\nProcesses consuming the most resources:"
ps aux --sort=-%cpu | head -n 10

# Monitor disk space of all mounted filesystems
echo -e "\nDisk space of all mounted filesystems:"
df -h

# Count and display critical messages and errors in system logs
echo -e "\nCritical messages and errors in system logs:"
echo "Syslog:"
grep -i 'crit\|error' /var/log/syslog | wc -l
echo "dmesg:"
dmesg | grep -i 'crit\|error' | wc -l

# Output summary of metrics for quick analysis
echo -e "\nSummary of metrics:"
echo "CPU and memory usage:"
top -b -n1 | head -n 5
echo -e "\nProcesses:"
ps aux --sort=-%cpu | head -n 5
echo -e "\nDisk space:"
df -h | head -n 5
echo -e "\nSystem logs:"
echo "Syslog critical messages and errors:"
grep -i 'crit\|error' /var/log/syslog | wc -l
echo "dmesg critical messages and errors:"
dmesg | grep -i 'crit\|error' | wc -l