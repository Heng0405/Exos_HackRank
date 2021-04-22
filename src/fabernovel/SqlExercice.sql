SELECT DISTINCT c.company_code, c.founder, count(DISTINCT lm.lead_manager_code), count(DISTINCT sm.senior_manager_code), count(DISTINCT m.manager_code),count(DISTINCT e.employee_code)
FROM Company c
LEFT JOIN lead_manager lm ON c.company_code = lm.company_code
LEFT JOIN senior_manager sm ON lm.lead_manager_code = sm.lead_manager_code
LEFT JOIN manager m ON sm.senior_manager_code = m.senior_manager_code
LEFT JOIN employee e ON m.manager_code = e.manager_code
GROUP by c.company_code, c.founder
ORDER BY company_code ASC;
