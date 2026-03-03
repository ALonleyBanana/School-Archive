/*
** Author: Timothy Victori
** Course: IFT/300
** SQL Server Version: Microsoft SQL server 2022
** OS: Windows 10
** History
** Date Created    Comments
** 01/31/2026      Chapter 4 Assignment Question 3
*/
SELECT v.VendorName, v.DefaultAccountNo, g.AccountDescription
FROM Vendors v 
JOIN GLAccounts g ON v.DefaultAccountNo = g.AccountNo;