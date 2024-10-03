
import React from 'react'
import { Link, useParams } from 'react-router-dom'


function AccountVerificationComponent() {
  
    const { id } = useParams()

    return (
    <div className="container">
        
        <span>{id}</span>

    </div>
  )
}

export default AccountVerificationComponent