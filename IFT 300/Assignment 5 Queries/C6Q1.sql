/*
** Author: Timothy Victori
** Course: IFT/300
** SQL Server Version: Microsoft SQL server 2022
** OS: Windows 10
** History
** Date Created    Comments
** 02/15/2026      Chapter 6 Assignment Question 1
*/
/*Query For Question 1 Using WHERE instead of JOIN*/
SELECT DISTINCT VendorName
FROM Vendors v
WHERE v.VendorID 
IN (SELECT i.VendorID FROM Invoices i)
 ORDER BY VendorName;

/* Code replicated by above query */
SELECT DISTINCT VendorName
FROM Vendors v
JOIN Invoices i
ON v.VendorID = i.VendorID ORDER BY VendorName;