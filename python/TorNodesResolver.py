import sys
import requests

req = requests.get("https://check.torproject.org/torbulkexitlist")
content = str(req.content)
nodes = content.split("\\n")

def isNode (address):
    return address in nodes