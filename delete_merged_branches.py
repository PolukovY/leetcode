import subprocess

def get_merged_branches():
    # Get a list of branches that have been merged into the current branch (usually "main" or "master").
    merged_branches = []
    try:
        merged_branches = subprocess.check_output(["git", "branch", "--merged"]).decode("utf-8").splitlines()
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
    # Get the list of merged branches.
    merged_branches = get_merged_branches()

    # Exclude the main branch from the list of branches to delete.
    current_branch = subprocess.check_output(["git", "rev-parse", "--abbrev-ref", "HEAD"]).decode("utf-8").strip()
    if current_branch in merged_branches:
        merged_branches.remove(current_branch)

    # List the merged branches before deletion.
    list_merged_branches(merged_branches)

    # Confirm with the user before proceeding.
    user_input = input("Do you want to delete the above branches? (y/n): ")
    if user_input.lower() == "y":
        # Delete the merged branches.
        delete_merged_branches(merged_branches)
    else:
        print("Branch deletion canceled.")
