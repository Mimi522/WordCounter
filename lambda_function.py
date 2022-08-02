import json
import re

def lambda_handler(event, context):
    text = event.get('body')
    
    if not text:
        return {
            'statusCode': 400,
            'body': json.dumps({'error': 'Some text input is required.'})
        }

    count = count_words(text)    

    return {
        'statusCode': 200,
        'body': json.dumps({'result': count})
    }

def count_words(text):
    wordList = re.findall(r"\w+", text)
    
    return len(wordList)
