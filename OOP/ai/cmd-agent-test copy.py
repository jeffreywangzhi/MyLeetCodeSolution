def list_files(directory="."):
    # list local files
    return "file list"
def read_file(file_path):
    # read file path
    return "file content"
def write_file(file_path, content):
    # write the file
    # human confirm
    return "file, content"

ava_funcs = ["a", "b"]
tools = [
    {
        "type": "function",
        "function": {
            "name": "list_files",
            "description": "list files",
            "paramenters": {
                "dir": {
                    "type": "string",
                    "description": "the dir to file"
                }
            }
        }
    },
    {
        "type": "function",
        "function": {
            "name": "read_file",
            "description": "read the file",
            "parameters": {
                "path": {
                    "type": "string",
                    "description": "path to the file"
                }
            }
        }
    }
]

def main():
    client = openAI_client()
    messages = [
        {
            "role": "system",
            "content": "ur a cmd agent, based on user input select and operate the correct tool call with concise"
        }
    ]
print("🤖 AI Terminal Agent initialized. Type 'exit' to quit.")

while True:
    user_input = input("\nAgent> ")
    if user_input.lower in ["quit","exit"]: break
    messages.append({"role": "user", "content": user_input})

    # Step A: send prompt and tools to llm
    response = client.create(
        model="gpt",
        messages=messages,
        tools=tools,
        tool_choice=auto
    )
    messages.append(response)

    # Step B: check if the llm wants to call a tool
    for tool_call in response.tool_calls:
        function_name = tool_call.function.name
        function_args = json.loads(tool_call.function.args)
        print(f"[⚙️ Executing tool: {function_name}({function_args})]")
        function_to_call = ava_funcs.get(function_name)
        if function_to_call:
            function_response = function_to_call(**function_args)

            # Step C: Send the function's result back to the LLM
            messages.append(function_response)

    final_response = client_create(
        model="gpt",
        messages=messages,
    )
    final_message = final_response.message
    messages.append(final_message)
    

