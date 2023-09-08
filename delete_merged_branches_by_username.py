import subprocess

def get_merged_branches(author):
    # Get a list of branches that have been merged by the specified author.
    merged_branches = []
    try:
        # Use git log to find merge commits by the specified author.
        merge_commits = subprocess.check_output(["git", "log", "--merges", "--author", author, "--oneline"]).decode("utf-8").splitlines()

        for commit in merge_commits:
            # Extract the branch name from the merge commit message.
            branch_name = commit.split(": ", 1)[1]
            merged_branches.append(branch_name)
    except subprocess.CalledProcessError as e:
        print(f"Error: {e}")
    return merged_branches

def list_merged_branches(branches_to_list):
    # List the branches that will be deleted.
    print("Merged branches to delete:")
    for branch in branches_to_list:
        print(branch)

def delete_merged_branches(branches_to_delete):
    # Delete the specified branches.
    for branch in branches_to_delete:
        try:
            subprocess.check_call(["git", "branch", "-d", branch])
            print(f"Deleted branch: {branch}")
        except subprocess.CalledProcessError as e:
            print(f"Error deleting branch {branch}: {e}")

if __name__ == "__main__":
    # Specify the author's name (your name) for filtering.
    author_name = "yepo"

    # Get the list of merged branches by the specified author.
    merged_branches = get_merged_branches(author_name)

    # List the merged branches before deletion.
    list_merged_branches(merged_branches)

    # Confirm with the user before proceeding.
    user_input = input("Do you want to delete the above branches? (y/n): ")
    if user_input.lower() == "y":
        # Delete the merged branches.
        delete_merged_branches(merged_branches)
    else:
        print("Branch deletion canceled.")
