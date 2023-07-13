# MRG Virtual Coffee

### Introduce
This is a script to generate pairing list for MRG quarterly virtual coffee chat.

### How to run
1. Put member info in MRG_members.csv file under /input directory
2. (Optional) Copy history pairing file under input/history folder if necessary
3. (Optional) Add blacklist file under input folder if necess
4. Execute the program and find the matching result under /output directory

### Matching rules
1. Members within the same team cannot be matched
2. Member pairs who have been matched in previous runs cannot be matched
3. Member pairs in black list cannot be matched

### Mock

input file

<img width="498" alt="Screenshot 2023-07-13 at 12 44 17 PM" src="https://github.com/JingciLi2022/MRG_virtual_coffee/assets/112975159/6bb9aeaf-8144-4206-a52e-35431f00c6af">



output file

<img width="764" alt="Screenshot 2023-07-13 at 12 47 07 PM" src="https://github.com/JingciLi2022/MRG_virtual_coffee/assets/112975159/e8e53eb6-fca3-4d49-997c-cbccce106c6c">


### Version History

- V2: `07/13/2023` support avoid matching members in blacklist and who have been matched previously
- V1: `05/07/2023` support avoid matching members in the same team
