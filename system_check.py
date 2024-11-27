import os
import subprocess

def run_command(command):
    result = subprocess.run(command, shell=True, capture_output=True, text=True)
    return result.stdout.strip()

def main():
    # Check CPU and memory usage
    print("CPU and memory usage:")
    print(run_command("top -b -n1 | head -n 10"))

    # Identify processes consuming the most resources
    print("\nProcesses consuming the most resources:")
    print(run_command("ps aux --sort=-%cpu | head -n 10"))

    # Monitor disk space of all mounted filesystems
    print("\nDisk space of all mounted filesystems:")
    print(run_command("df -h"))

    # Count and display critical messages and errors in system logs
    print("\nCritical messages and errors in system logs:")
    print("Syslog:")
    print(run_command("grep -i 'crit\\|error' /var/log/syslog | wc -l"))
    print("dmesg:")
    print(run_command("dmesg | grep -i 'crit\\|error' | wc -l"))

    # Output summary of metrics for quick analysis
    print("\nSummary of metrics:")
    print("CPU and memory usage:")
    print(run_command("top -b -n1 | head -n 5"))
    print("\nProcesses:")
    print(run_command("ps aux --sort=-%cpu | head -n 5"))
    print("\nDisk space:")
    print(run_command("df -h | head -n 5"))
    print("\nSystem logs:")
    print("Syslog critical messages and errors:")
    print(run_command("grep -i 'crit\\|error' /var/log/syslog | wc -l"))
    print("dmesg critical messages and errors:")
    print(run_command("dmesg | grep -i 'crit\\|error' | wc -l"))

print

if __name__ == "__main__":
    main()