Get repos by 100 

```
curl -s  'https://api.github.com/users/ContainerSolutions/repos?&per_page=100&page=1' >> repos.json
curl -s  'https://api.github.com/users/ContainerSolutions/repos?&per_page=100&page=2' >> repos.json
```

glue arrays manualy and filter 
```
jq '[.[] | {name: .name, issues_url: .issues_url }]' repos.json > repos_with_issue_url.json
```